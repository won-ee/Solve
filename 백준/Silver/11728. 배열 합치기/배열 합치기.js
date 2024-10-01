const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = require('fs').readFileSync(filePath).toString().split('\n');
const n = +input[0][0];
const m = +input[0][1];
const numsA = input[1].split(' ').map((num) => +num);
const numsB = input[2].split(' ').map((num) => +num);

const answer = solution(numsA, numsB);
console.log(answer.trim());

function solution(numsA, numsB) {
  let result = [];
  result.push(...numsA);
  result.push(...numsB);
  return result.sort((a, b) => a - b).join(' ');
}