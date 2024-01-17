import React from "react";
import {useState} from "react";
import OneApp from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";
import FiveApp from "./FiveApp";
import SixApp from "./SixApp";

function MainApp(props) {
  const [index, setIndex] = useState(1);

  const onChangeApp = (e) => {
    setIndex(Number(e.target.value));
  };

  return (
    <div style={{margin: "30px"}}>
      <div>
        <h3 className="alert alert-success">2024-01-17 리액트수업</h3>
      </div>
      <label>
        <input
          type="radio"
          defaultValue={1}
          name="myapp"
          defaultChecked
          onClick={onChangeApp}
        />
        OneApp
      </label>
      <label style={{marginLeft: "20px"}}>
        <input
          type="radio"
          defaultValue={2}
          name="myapp"
          onClick={onChangeApp}
        />
        TwoApp
      </label>
      <label style={{marginLeft: "20px"}}>
        <input
          type="radio"
          defaultValue={3}
          name="myapp"
          onClick={onChangeApp}
        />
        ThreeApp
      </label>
      <label style={{marginLeft: "20px"}}>
        <input
          type="radio"
          defaultValue={4}
          name="myapp"
          onClick={onChangeApp}
        />
        FourApp
      </label>
      <br />
      <label>
        <input
          type="radio"
          defaultValue={5}
          name="myapp"
          onClick={onChangeApp}
        />
        FiveApp
      </label>
      <label style={{marginLeft: "20px"}}>
        <input
          type="radio"
          defaultValue={6}
          name="myapp"
          defaultChecked
          onClick={onChangeApp}
        />
        SixApp
      </label>
      <hr />
      {index === 1 ? (
        <OneApp />
      ) : index === 2 ? (
        <TwoApp />
      ) : index === 3 ? (
        <ThreeApp />
      ) : index === 4 ? (
        <FourApp />
      ) : index === 5 ? (
        <FiveApp />
      ) : (
        <SixApp />
      )}
    </div>
  );
}

export default MainApp;
