const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = require('fs').readFileSync(filePath).toString().trim().split('\n').map((v) => v.split(' ').map(Number));
const [N, K] = input.shift();

// 양동이 좌표의 범위가 0부터 1,000,000까지 있으므로 배열 크기를 1,000,001로 설정
const arr = new Array(1000001).fill(0);

// 입력값을 배열에 반영 (좌표에 얼음의 양을 더함)
input.forEach(([g, x]) => {
    arr[x] = g;
});

let temp = 0;
let ans = 0;

// 처음 슬라이딩 윈도우 설정 (좌표 0부터 2*K까지의 얼음 합을 계산)
for (let i = 0; i <= Math.min(2 * K, 1000000); i++) {
    temp += arr[i];
}
ans = temp;

// 슬라이딩 윈도우를 이용해 배열을 순회하며 최대값을 찾음
for (let i = 2 * K + 1; i <= 1000000; i++) {
    temp += arr[i];                 // 새로운 좌표의 양동이 얼음을 더하고
    temp -= arr[i - (2 * K + 1)];   // 범위에서 벗어난 좌표의 양동이 얼음을 뺌
    ans = Math.max(ans, temp);      // 최대 얼음 합 갱신
}

console.log(ans);
