import React, {useState} from "react";

function SixApp(props) {
  const [mycar, setMyCar] = useState(["2", "7"]);
  const [carNum, setCarNum] = useState("");

  return (
    <div>
      <h3 className="alert alert-danger">SixApp</h3>
      <input
        type="text"
        placeholder="자동차번호 입력 후 엔터"
        className="form-control"
        style={{width: "300px"}}
        value={carNum}
        onChange={(e) => setCarNum(e.target.value)}
        onKeyUp={(e) => {
          if (e.key === "Enter") {
            // 1 ~15가 아니면 경고 후 종료
            if (carNum < 1 || carNum > 15) {
              alert("1부터 15사이의 값을 입력하세요.");
            }
            // 배열 mycar 에 carNum 값 추가
            setMyCar([...mycar, carNum]);

            // setMyCar(mycar.concat(carNum));
            // carNum 값 초기화
            setCarNum("");
          }
        }}
      />
      {/* 1~15 사이 번호입력 후 엔터를 누르면 해당자동차 이미지로 출력하고
      해당 자동차 이미지에서 더블클릭하면 자동차 삭제하기 */}
      {
        /* mycar 배열 이미지로 출력*/
        mycar.map((photo, i) => (
          <img
            key={i}
            alt=""
            style={{cursor: "pointer"}}
            src={require(`./images/mycar${photo}.png`)}
            width="100"
            hspace="10"
            vspace="10"
            onDoubleClick={(e) => {
              alert(i + "이미지 삭제!");
              setMyCar(mycar.filter((pic, idx) => i !== idx));
            }}
          />
        ))
      }
    </div>
  );
}

export default SixApp;
