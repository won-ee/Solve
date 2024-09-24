const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = require('fs').readFileSync(filePath).toString().trim().split('\n');
let n = +input[0]
let N = input[1].split(' ').map(Number).sort((a,b) => a-b)
let M = input[3].split(' ').map(Number)

const solution = (n,N,M) =>{
    let ans = []
    M.forEach(
        val => {
            const low = lower(N,val,0,n-1)
            const up = upper(N,val,0,n-1)
            let ret = 0
            if (low !== -1 && up !==-1){
                ret = low - up + 1
            } else {
                ret = 0
            }
            ans.push(ret)
        }
    )
    console.log(ans.join(' '))
}
const lower = (array, target, start, end) => {
    let answer = -1;
    while(start<=end){
        mid = Math.floor((start+end)/2)
        if(array[mid] === target){
            answer = mid
            end = mid -1 ;
        }else if(array[mid]>target){
            end = mid-1;
        }else{
            start = mid+1
        }
    }
    return answer;
  };
  
  const upper = (array, target, start, end) => {
    let answer = -1;
    while(start<=end){
        mid = Math.floor((start+end)/2)
        if(array[mid] === target){
            answer = mid
            start = mid + 1;
        }else if(array[mid]>target){
            end = mid-1;
        }else{
            start = mid+1
        }
    }
    return answer;
  };
  
solution(n,N,M)