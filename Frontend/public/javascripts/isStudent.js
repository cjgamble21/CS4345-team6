const isStudent = () => {
  const currentDate = new Date().getFullYear();
  const possibleStartDates = [currentDate - 3, currentDate - 2, currentDate - 1, currentDate];
  const possibleGraduateDates = [currentDate, currentDate + 1, currentDate + 2, currentDate + 3];

  const column1 = `
      <div class="item-2">
      <label for="degree" class="remove">Degree Plan</label>
      <select id="degree" name="degreePlan" class="remove">
          <option value="Ph.D">Ph.D.</option>
          <option value="D.E.-SE">D.E.-SE</option>
          <option value="MS-CS">MS-CS</option>
          <option value="MS-SE">MS-SE</option>
          <option value="MS-Cybersecurity">MS-Cybersecurity</option>
          <option value="BS-CS">BS-CS</option>
          <option value="BA-CS">BA-CS</option>
      </select>
      </div>
      `;

  const column2 = `

      <div class="column-2 remove">
      <div class="item-3">
      <label for="startdate">Degree Begin</label>
      <select id="startdate" name="degreeBegin">
          <option value="Fall ${possibleStartDates[0]}">Fall ${possibleStartDates[0]}</option>
          <option value="Spring ${possibleStartDates[0]}">Spring ${possibleStartDates[0]}</option>
          <option value="Fall ${possibleStartDates[1]}">Fall ${possibleStartDates[1]}</option>
          <option value="Spring ${possibleStartDates[1]}">Spring ${possibleStartDates[1]}</option>
          <option value="Fall ${possibleStartDates[2]}">Fall ${possibleStartDates[2]}</option>
          <option value="Spring ${possibleStartDates[2]}">Spring ${possibleStartDates[2]}</option>
          <option value="Fall ${possibleStartDates[3]}">Fall ${possibleStartDates[3]}</option>
          <option value="Spring ${possibleStartDates[3]}">Spring ${possibleStartDates[3]}</option>
      </select>
      </div>

      <div class="item-4">
      <label for="graddate">Graduation Date</label>
      <select id="graddate" name="gradDate">
          <option value="Fall ${possibleGraduateDates[0]}">Fall ${possibleGraduateDates[0]}</option>
          <option value="Spring ${possibleGraduateDates[0]}">Spring ${possibleGraduateDates[0]}</option>
          <option value="Fall ${possibleGraduateDates[1]}">Fall ${possibleGraduateDates[1]}</option>
          <option value="Spring ${possibleGraduateDates[1]}">Spring ${possibleGraduateDates[1]}</option>
          <option value="Fall ${possibleGraduateDates[2]}">Fall ${possibleGraduateDates[2]}</option>
          <option value="Spring ${possibleGraduateDates[2]}">Spring ${possibleGraduateDates[2]}</option>
          <option value="Fall ${possibleGraduateDates[3]}">Fall ${possibleGraduateDates[3]}</option>
          <option value="Spring ${possibleGraduateDates[3]}">Spring ${possibleGraduateDates[3]}</option>
      </select>
      </div>
      </div>
  `;
  let status = document.getElementById('status').value;

  if (status == "Student") {
    document.getElementById('non-student').insertAdjacentHTML("beforeend", column1);
    document.getElementById('conditional').insertAdjacentHTML("beforeend", column2);
  } else {
    document.querySelectorAll('.remove').forEach(e => e.remove());
  }
}
