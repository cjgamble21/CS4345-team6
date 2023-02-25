const currentDate = new Date().getFullYear();
const possibleStartDates = [currentDate - 3, currentDate - 2, currentDate - 1, currentDate];
const possibleGraduateDates = [currentDate, currentDate + 1, currentDate + 2, currentDate + 3];

let start = document.querySelector('#startdate');
let grad = document.querySelector('#graddate');
for (let i = 0; i < start.length / 2; i++) {
    start.options[i * 2].value += ` ${possibleStartDates[i]}`;
    start.options[i * 2].text += ` ${possibleStartDates[i]}`;

    start.options[i * 2+ 1].value += ` ${possibleStartDates[i]}`;
    start.options[i * 2+ 1].text += ` ${possibleStartDates[i]}`;

    grad.options[i * 2].value += ` ${possibleGraduateDates[i]}`;
    grad.options[i * 2].text += ` ${possibleGraduateDates[i]}`;

    grad.options[i * 2+ 1].value += ` ${possibleGraduateDates[i]}`;
    grad.options[i * 2+ 1].text += ` ${possibleGraduateDates[i]}`;
}


const isStudent = () => {
  let status = document.querySelector('#status').value;

  if (status === "Student") {
      document.querySelector('.item-2').classList.remove('hide');
      document.querySelector('.column-2').classList.remove('hide');
  } else {
      document.querySelector('.item-2').classList.add('hide');
      document.querySelector('.column-2').classList.add('hide');
  }
}
