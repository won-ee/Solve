const { log } = require('console');
const fs = require('fs');
// const readFileSyncAddress = 'input.txt';
const readFileSyncAddress = '/dev/stdin';
const input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');
const N = +input.shift();
const arr = input.shift().split(" ").map(Number);
const dp = new Array(N).fill(0)

for(let i=0; i<N; i++){
    var max = 0
    for (let j=0; j<i; j++){
      if (arr[i] >arr[j] && dp[j]>max){
        max =dp[j]
      }
    }
    dp[i] = max +1;
}

console.log(Math.max(...dp));
