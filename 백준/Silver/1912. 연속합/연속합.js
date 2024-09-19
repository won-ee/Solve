const { log } = require('console');
const fs = require('fs');
// const readFileSyncAddress = 'input.txt';
const readFileSyncAddress = '/dev/stdin';
const input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');
const N = +input.shift();
const arr = input.shift().split(" ").map(Number);
const dp = arr.slice()

for (let i= 1; i<N; i++){
    dp[i] = arr[i] > arr[i] + dp[i-1] ? arr[i] : arr[i] + dp[i-1];
}

console.log(Math.max(...dp));