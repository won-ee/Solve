const fs = require('fs');
// const readFileSyncAddress = 'input.txt';
const readFileSyncAddress = '/dev/stdin';
const input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');
const N = +input.shift();
const arr = input.map(info => info.split(' ').map(val => +val));

function solution(n,arr) {
    const dp = new Array(n).fill(0);

    for (let i = 0; i < n; i++) {
      const [duration, profit] = arr[i];
      if (i + duration > n) continue; 
      dp[i] += profit;
      for (let j = i + duration; j < n; j++) {
        dp[j] = Math.max(dp[j], dp[i]); 
      }
    }
    console.log(Math.max(...dp));
}

solution(N,arr)