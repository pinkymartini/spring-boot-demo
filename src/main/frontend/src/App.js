import logo from './logo.svg';
import './App.css';
import { useEffect,useState } from 'react';
import axios from 'axios';






function App() {

  const [users, setUsers] = useState([])
  const name = "sad"

  const mystyle = {
    color: "white",
    backgroundColor: "DodgerBlue",
    padding: "10px",
    fontFamily: "Arial",

    
  };

  

  useEffect(() => {

  axios.get("http://localhost:8080/api/v1/student").then(res=>{

  setUsers(res.data);

  })
    
  }, [])

  return users.map((user,index)=>{

    return(

      <div style = {{flex:1, paddingLeft:200, paddingRight:200}} >

        <div style = {{flex:1, display:'block-flex',textAlign:'center', backgroundColor:'grey',paddingLeft:200, paddingRight:200}}>

        <h1  style={{color:'red',backgroundColor:'green'}}>{user.name}</h1>
        <h1 style ={mystyle}>{user.email}</h1>

        </div>

      </div>

    )
  })
 
}



export default App;
