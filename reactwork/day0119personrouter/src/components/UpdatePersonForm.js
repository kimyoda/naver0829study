import React from "react";
import {useParams} from "react-router-dom";
import {useState} from "react";
import {useNavigate} from "react-router-dom";
import {useEffect} from "react";
import axios from "axios";
import {Alert, Button} from "@mui/material";
import {Add, ArtTrack} from "@mui/icons-material";

const UpdatePersonForm = () => {
  const [person, setPerson] = useState({
    name: "",
    age: "",
    blood: "A",
    photo: "1.jpg",
  });
  const {personNum} = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    // Fetch the person data from the server
    axios
      .get(`/person/select?personNum=${personNum}`)
      .then((response) => {
        setPerson(response.data);
      })
      .catch((error) => {
        console.error("There was an error fetching the person data", error);
      });
  }, []);

  // Update button event handler
  const updateDataEvent = () => {
    axios
      .post(`/person/update`, person)
      .then((res) => {
        navigate("/");
      })
      .catch((error) => {
        console.error("There was an error updating the person data", error);
      });
  };

  const handleChange = (e) => {
    const {name, value} = e.target;
    setPerson((prevPerson) => ({
      ...prevPerson,
      [name]: value,
    }));
  };

  return (
    <div className="mainbox">
      <Alert variant="filled" severity="info">
        Person 멤버 수정
      </Alert>
      <div style={{marginTop: "20px"}}>
        <table className="table table-bordered">
          <tbody>
            <tr>
              <th style={{width: "100px", backgroundColor: "#ccc"}}>이름</th>
              <td>
                <input
                  type="text"
                  name="name"
                  value={person.name}
                  onChange={handleChange}
                  className="form-control"
                  style={{width: "150px"}}
                />
              </td>
            </tr>
            <tr>
              <th style={{width: "100px", backgroundColor: "#ccc"}}>나이</th>
              <td>
                <input
                  type="number"
                  name="age"
                  value={person.age}
                  onChange={handleChange}
                  className="form-control"
                  style={{width: "150px"}}
                />
              </td>
            </tr>
            <tr>
              <th style={{width: "100px", backgroundColor: "#ccc"}}>혈액형</th>
              <td>
                <select
                  name="blood"
                  value={person.blood}
                  onChange={handleChange}
                  className="form-select"
                  style={{width: "150px"}}
                >
                  <option value="A">A</option>
                  <option value="B">B</option>
                  <option value="O">O</option>
                  <option value="AB">AB</option>
                </select>
              </td>
            </tr>
            <tr>
              <th style={{width: "100px", backgroundColor: "#ccc"}}>사진</th>
              <td className="input-group">
                <img
                  alt=""
                  src={require(`../images/${person.photo}`)}
                  style={{width: "80px", marginRight: "10px"}}
                />
                <select
                  name="photo"
                  value={person.photo}
                  onChange={handleChange}
                  className="form-select"
                  style={{width: "150px", height: "40px"}}
                >
                  {[...Array(20)].map((_, idx) => (
                    <option key={idx} value={`${idx + 1}.jpg`}>
                      {idx + 1}.jpg
                    </option>
                  ))}
                </select>
              </td>
            </tr>
            <tr>
              <td colSpan={2} align="center">
                <Button
                  variant="outlined"
                  onClick={updateDataEvent}
                  style={{margin: "10px"}}
                >
                  수정
                </Button>
                <Button
                  variant="outlined"
                  onClick={() => navigate("/")}
                  style={{margin: "10px"}}
                >
                  목록
                </Button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default UpdatePersonForm;
