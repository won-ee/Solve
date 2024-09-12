const input = +require("fs").readFileSync("/dev/stdin").toString().trim();


function solution(a) {
 if (a%2==0){
    return 'CY'
 }else{
    return 'SK'
 }
}

let ans = solution(input)

console.log(ans);
