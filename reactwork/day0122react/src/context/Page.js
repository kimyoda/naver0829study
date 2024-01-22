import React, {useContext} from "react";
import Header from "./Header";
import Content from "./Content";
import Footer from "./Footer";
import {ThemeContext} from "./ThemeContext";

const Page = () => {
  const {isDark} = useContext(ThemeContext);

  return (
    <div>
      <Header />
      <Content />
      <Footer />
    </div>
  );
};

export default Page;
