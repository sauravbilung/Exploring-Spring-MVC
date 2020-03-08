<html>
<head>
<title>Success!!!</title>
</head>

<body>
     <h1>${headerMsg} </h1>
     <h2>Details entered by you are as follows:</h2>
     <table>
         <tr>
            <td> Student Name:</td>
            <td> ${student.studentName} </td>
         </tr>
         <tr>
            <td>Preferred Branch:</td>
            <td>${student.studentBranch}</td>
         </tr>
         <tr>
             <td>Student Mobile:</td>
              <td>${student.studentMobile}</td>
         </tr>
         <tr>
            <td>Student DOB:</td>
            <td>${student.studentDOB}</td>
        </tr>
         <tr>
             <td>Student Skills:</td>
             <td>${student.studentSkills}</td>
        </tr>
        <tr>
             <td>Student's Address :</td>
             <td>Country : ${student.studentAddress.country}</td>
             <td>City : ${student.studentAddress.city}</td>
             <td>Street : ${student.studentAddress.street}</td>
             <td>Pin code : ${student.studentAddress.pincode}</td>
        </tr>
</table>
</body>
</html>