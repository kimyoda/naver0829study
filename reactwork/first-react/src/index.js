import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import First from "./FirstComponent";

import reportWebVitals from "./reportWebVitals";
import SecondApp from "./SecondApp";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    {/* <App /> */}
    <First />
    {/* 아래처럼 입력을 하면 자동으로 import가 된다 */}
    <SecondApp />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
