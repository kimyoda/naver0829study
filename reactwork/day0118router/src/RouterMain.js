import {Route, Routes} from "react-router-dom";
import Menu from "./components/Menu";
import React from "react";
import {About, Food, Home} from "./pages";

const RouterMain = () => {
  return (
    <div>
      <Menu />
      <hr style={{clear: "both"}} />
      <Routes>
        {/* <Route path="/home" element={<Home />} /> */}

        {/* home에 서브 메뉴를 만들고자 할 경우 */}
        <Route path="/home/*" element={<Home />} />

        {/* <Route path="/about" element={<About />} /> */}

        {/* 파라미터를 보내는 경우 : 방법 1 */}
        {/* <Route path="/about/:emp" element={<About />} /> */}

        {/* 파라미터를 보내는 경우 : 방법 2 */}
        <Route path="/about" element={<About />}>
          <Route path=":emp" element={<About />} />
        </Route>

        <Route path="/food" element={<Food />}>
          <Route path=":food1/:food2" element={<Food />} />
          <Route path=":food1" element={<Food />} />
        </Route>

        {/* 그 외의 맵핑 주소로 */}
        <Route
          path="*"
          element={
            <div>
              <h1>잘못된 url 주소입니다</h1>
              <br></br>
              <img alt="" src={require(`./image/s2.JPG`)} />
            </div>
          }
        />
      </Routes>
    </div>
  );
};

export default RouterMain;
