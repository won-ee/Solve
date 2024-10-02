const fs = require('fs')
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin":"입력.txt")
  .toString().trim().split('\n')

function solution(arr) {
  arr.shift()
  const table = {}
  arr.forEach(el => table[el] = true)

  let max = 0
  arr.forEach((el)=> {
    let cnt = 0
    for(let i = 1 ; i < 5 ; i ++) {
      table[+el + i] && cnt ++
    }
    max = cnt > max ? cnt : max
  })
  console.log(4-max)
}

solution(input)
