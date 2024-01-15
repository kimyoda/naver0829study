import React, {useState} from "react";

function SevenApp(props) {
  const [array, setArray] = useState([
    {title: "귀여운 원시인", price: "23000", color: "orange", photo: "C1"},
    {title: "귀여운 고양이", price: "11000", color: "pink", photo: "C2"},
    {title: "귀여운 강아지", price: "30000", color: "yellow", photo: "C3"},
    {title: "귀여운 원숭이", price: "25000", color: "gray", photo: "C4"},
  ]);

  // const [data, setData] = useState("");

  return (
    <div>
      <h3 className="alert alert-success">SevenApp-배열 출력</h3>
      <table className="table table-bordered" style={{width: "400px"}}>
        <tbody>
          {array.map((item, i) => (
            <tr key={i}>
              <td style={{width: "150px"}}>
                <img
                  alt=""
                  width="130"
                  src={require(`./images/${item.photo}.png`)}
                />
              </td>
              <td>
                제목 : {item.title}
                <br />
                가격 : {item.price}원<br />
                색상 : <b style={{backgroundColor: item.color}}>{item.color}</b>
                <br />
                <button
                  type="button"
                  className="btn btn-danger btn-sm"
                  onClick={() => {
                    setArray(array.filter((arrayPic, idx) => i !== idx));
                  }}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default SevenApp;
