import React, {useState} from "react";
import T1_1 from "../images/T1_1.jpg";
import "./MyStyle.css";
import C1 from "../images/C1.png";
import C2 from "../images/C2.png";
import C3 from "../images/C3.png";
import C4 from "../images/C4.png";
import C5 from "../images/C5.png";

function FiveApp(props) {
  const [show, setShow] = useState(true);
  const [photo, setPhoto] = useState(C1);
  const [border, setBorder] = useState("insert");

  return (
    <div className="box">
      <h3 className="alert alert-warning">
        FiveApp
        <img alt="" src={T1_1} style={{width: "60px", float: "right"}} />
      </h3>
      <div>
        <label>
          <input
            type="checkbox"
            defaultChecked
            onClick={(e) => {
              setShow(e.target.checked);
            }}
          />
          이미지 보이기 / 숨기기
        </label>
        <br />
        <br />
        <select
          className="form-select"
          style={{width: "200px"}}
          onChange={(e) => {
            setPhoto(e.target.value);
          }}
        >
          <option value={C1}>영식이</option>
          <option value={C2}>영호</option>
          <option value={C3}>옥순</option>
          <option value={C4}>영철</option>
          <option value={C5}>순자</option>
        </select>
        <br />
        <br />
        <select
          className="form-select"
          style={{width: "200px"}}
          onChange={(e) => {
            setBorder(e.target.value);
          }}
        >
          <option>inset</option>
          <option>dotted</option>
          <option>solid</option>
          <option>dashed</option>
          <option>double</option>
          <option>groove</option>
        </select>
        <br />
        <br />
        {
          // show 값이 true면 이미지가 보이고, false면 안보인다.
          show && (
            <img alt="" src={photo} style={{border: `10px ${border} gray`}} />
          )
        }
      </div>
    </div>
  );
}

export default FiveApp;
