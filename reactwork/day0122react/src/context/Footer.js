import React, {useContext} from "react";
import {ThemeContext} from "./ThemeContext";

const Footer = () => {
  const {isDark, setIsDark, doll} = useContext(ThemeContext);

  return (
    <footer
      className="footer"
      style={{backgroundColor: isDark ? "black" : "lightgray"}}
    >
      <button
        type="button"
        className="button"
        onClick={() => setIsDark(!isDark)}
      >
        <img alt="" src={require(`../image/${doll}`)} width="30px" />
        Dark Mode
      </button>
    </footer>
  );
};

export default Footer;