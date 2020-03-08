<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head><title>Admission Form</title></head>
<body>
      <h1>${headerMsg} </h1>
      <h2>Student Admission Form for Engineering</h2>
      <form:errors path="student.*"/>
      <form action="/SpringMVC/submitAdmissionForm.html" method=POST>
       <p>
          Student's Name:<input type="text" name="studentName"/>
       </p>
       <p>
         Preferred Branch:<input type="text" name="studentBranch"/>
       </p>
       <p>
          Student's Mobile :<input type="text" name="studentMobile"/>
       </p> 
       <p>
          Student's DOB :<input type="text" name="studentDOB"/>(dd/mm/yyyy)
       </p>
       <p>
         Student's skills set:<select name="studentSkills" multiple>
                              <option value="Java Core"> Java Core</option>
                              <option value="Angular"> Angular</option>
                              <option value="AWS">AWS</option>
                              </select>
       </p>
       <table>
         <tr><td>Student's Address</td></tr>
         <tr>
            <td>Country :<input type="text" name="studentAddress.country"/></td>
            <td>city: <input type="text" name="studentAddress.city"/></td>
            <td>street: <input type="text" name="studentAddress.street"/></td>
            <td>pin code: <input type="text" name="studentAddress.pincode"/></td>
         </tr>
       </table>
        <input type="submit" value="Click here to Submit"/>
      </form>
</body>
</html>