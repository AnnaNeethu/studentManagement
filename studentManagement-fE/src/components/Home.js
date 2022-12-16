import React from "react";
import axios from  'axios';
import { Container, Row, Col } from 'react-bootstrap';
import { useState,useEffect } from "react";
import './Home.css'

function Home() {
    
    const [name, setName] = useState('');
    const [dob, setDob] = useState('');
    const [cls, setClass] = useState('');
    const [div, setDiv] = useState('');
    const [gender, setGender] = useState('');
    const [formErrors,setFormErrors] = useState({});
    const [stud,getStudent]= useState([]);
    const [flag,setFlag]=useState(false);

    const onSubmit = (e) => {
        e.preventDefault();
        const setStudent = {name,dob,cls,div,gender}
        console.log(setStudent)
        let checkValidation = validation(setStudent)
        setFormErrors(checkValidation)
        console.log('check',checkValidation);
        if(Object.keys(checkValidation).length===0){
            fetch("http://localhost:8080/addStudent",{
                method:"POST",
                headers:{"Content-Type":"application/json"},
                body:JSON.stringify(setStudent)
            }).then(function (response) {
                if (response.status == 200) {
                    setFlag(true)
                    setName('');
                    setDob('');
                    setClass('');
                    setDiv('');
                    setGender('')
                }
            })
        }
        else{
            console.log('error',checkValidation);
        }
       
    }
        async function fetchData() {
            await  fetch("http://localhost:8080/view",{
            }).then(res=>res.json())
            .then((result)=>{
                result.sort(function(a,b){
                    if (a.name.toLowerCase() < b.name.toLowerCase()) {
                        return -1;
                      }
                      if (a.name.toLowerCase() > b.name.toLowerCase()) {
                        return 1;
                      }
                      return 0;
                    });
                getStudent(result)})
          }
                    

    useEffect(()=>{
        // axios.get("http://localhost:8080/view")
        // .then(res=>res.json())
        // .then((result)=>getStudent(result))
        setFlag(false);
        fetchData()
    
      }, [flag])
      
    const validation = (student)=>{
       const errors ={}
       const regex =  /^[a-zA-Z ]{3,}$/
       if(!student.name){
        errors.name = "Name is required"
       }else if(!regex.test(student.name)){
        errors.name = "Enter a valid name"
       }
       if(!student.dob){
        errors.dob = "Date of Birth is required"
       }
       if(!student.cls){
        errors.class = "Class is required"
       }
       if(!student.div){
        errors.division = "Division is required"
       }
       if(!student.gender){
        errors.gender = "Gender is required"
       }
       return errors;
    }


    return (
        <Container>
            <Row>
                <Col>
                    <h1 className="py-3">Add Student</h1>
                    <form onSubmit={(e) => onSubmit(e)} className="form-control py-3">
                        <label for="name">Name  </label>
                        <input type="text" id="name" name="name" placeholder="Enter student name" value={name}
                            onChange={e => setName(e.target.value)}   />
                            <p>{formErrors.name}</p>
                        <br />
                        <label for="dob">Date of Birth  </label>
                        <input type="date" id="dob" name="dob" placeholder="Enter date of birth" value={dob}
                            onChange={e => setDob(e.target.value)} />
                            <p>{formErrors.dob}</p>
                        <br />
                        <label for="class">Class  </label>
                        <select id="class" name="class"
                        value={cls}
                        onChange={e => setClass
                        
                        (e.target.value)}>
                            <option value="">Select</option>
                            <option value="1">I</option>
                            <option value="2">II</option>
                            <option value="3">III</option>
                            <option value="4">IV</option>
                            <option value="5">V</option>
                            <option value="6">VI</option>
                            <option value="7">VII</option>
                            <option value="8">VIII</option>
                            <option value="9">IX</option>
                            <option value="10">X</option>
                            <option value="11">XI</option>
                            <option value="12">XII</option>
                        </select>
                        <p>{formErrors.class}</p>
                        <br />
                        <label for="division">Division  </label>
                        <select id="division" name="division" value={div}
                            onChange={e => setDiv(e.target.value)} >
                            <option value="">Select</option>
                            <option value="A">A</option>
                            <option value="B">B</option>
                            <option value="C">C</option>
                        </select>
                        <p>{formErrors.division}</p>
                        <br />
                        <label for="gender">Gender </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="gender" value="male"
                            onChange={e => setGender(e.target.value)} /> Male
                        &nbsp;
                        <input type="radio" name="gender" value="female"
                            onChange={e => setGender(e.target.value)} /> Female
                            <p>{formErrors.gender}</p>
                        <br />
                        <input type="submit" value="Submit" />
                    </form>
                </Col>
                <Col>
                    <h1 className="py-3">Student List</h1>
                    <table className="py-3 border" id="studn">
                        <thead>
                            <tr className="border py-3">
                                <th>Name</th>
                                <th>Admission No:</th>
                                <th>Dob</th>
                                <th>Class</th>
                                <th>Division</th>
                                <th>Gender</th>
                            </tr>
                        </thead>

                        {stud.map(student=>(
                            <tr>
                                <td>{student.name}</td>
                                <td>{student.adNo}</td>
                                <td>{student.dob}</td>
                                <td>{student.cls}</td>
                                <td>{student.div}</td>
                                <td>{student.gender}</td>
                            </tr>
                            
                        ))}
                    </table>
                </Col>
            </Row>
        </Container>
    );
}

export default Home;
