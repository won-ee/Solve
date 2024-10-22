const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const N = parseInt(input[0]);
const route = input[1];

// 0: 동, 1: 남, 2: 서, 3: 북
const dix = [0, 1, 0, -1];
const diy = [1, 0, -1, 0];

const solution = () => {
  let way = [[0, 0]];  // 초기 위치 (0, 0)
  let dx = 0, dy = 0;
  let direc = 1;  // 시작 방향: 남쪽

  // 경로에 따라 이동
  for (let i = 0; i < N; i++) {
    if (route[i] === "R") {
      direc = (direc + 1) % 4;  // 시계방향 90도 회전
    } else if (route[i] === "L") {
      direc = (direc + 3) % 4;  // 반시계방향 90도 회전
    } else {
      dx += dix[direc];
      dy += diy[direc];
      way.push([dx, dy]);
    }
  }

  // 좌표의 최소, 최대값 구하기
  let [mnx, mxx] = [Number.MAX_SAFE_INTEGER, Number.MIN_SAFE_INTEGER];
  let [mny, mxy] = [Number.MAX_SAFE_INTEGER, Number.MIN_SAFE_INTEGER];

  way.forEach(([x, y]) => {
    mnx = Math.min(mnx, x);
    mxx = Math.max(mxx, x);
    mny = Math.min(mny, y);
    mxy = Math.max(mxy, y);
  });

  // 맵 생성 및 경로 표시
  const map = Array.from(Array(mxx - mnx + 1), () => Array(mxy - mny + 1).fill("#"));

  way.forEach(([x, y]) => {
    map[x - mnx][y - mny] = ".";
  });

  // 결과 출력
  const answer = map.map(row => row.join("")).join("\n");
  console.log(answer);
};

solution();
