import { ReactComponent as Githubicon } from "assets/img/github.svg";
import React from "react";
import { Link } from "react-router-dom";
import "./styles.css";
function Navbar2() {
  return (
    <header>
      <div className="container">
        <nav>
          <div className="dsmovie-nav-content ">
            <h1>DSmovie</h1>
            <a href="https://github.com/icsmv001">
              <div className="dsmovie-contact-container">
                <Githubicon />
                <p className="dsmovie-contatct-link">/devesuperior</p>
              </div>
            </a>
          </div>
        </nav>
      </div>
    </header>
  );
}

export default Navbar2;
