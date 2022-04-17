import { ReactComponent as Arrow } from "assets/img/arrow.svg";
import "./styles.css";

function Pagination2() {
  return (
    <div className="dsmovie-pagination2-container">
      <div className="dsmovie-pagination2-box">
        <button className="dsmovie-pagination2-button" disabled={true}>
          <Arrow />
        </button>
        <p>{`${1} de ${3}`}</p>
        <button className="dsmovie-pagination2-button" disabled={false}>
          <Arrow className="dsmovie-flip-horizontal" />
        </button>
      </div>
    </div>
  );
}

export default Pagination2;
