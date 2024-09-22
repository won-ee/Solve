const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = require('fs').readFileSync(filePath).toString().trim().split('\n');
const endIdx = Number(input[0]) - 1;
const A = input[1].split(' ').map(Number).sort((a, b) => a - b);
const B = input[3].split(' ').map(Number);

function binarySearch(arr, target, start, end) {
  while (start <= end) {
    const mid = Math.floor((start + end) / 2);

    if (target === arr[mid]) return 1;
    else if (target > arr[mid]) {
      start = mid + 1;
    } else {
      end = mid - 1;
    }
  }
  return 0;
}

const answer = B.map((b) => binarySearch(A, b, 0, endIdx));
console.log(answer.join('\n'));