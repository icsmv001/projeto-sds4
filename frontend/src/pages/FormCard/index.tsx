import { Link } from "react-router-dom";
import "./styles.css";
import React from "react";
import { useParams } from "react-router-dom";

//   <Route path="/FormCard/:idParam" component={FormCard}>

function FormCard() {
  /// objeto movie mocado, tras um mesmo resultado sempre, para teste
  const movie = {
    id: 13,
    image:
      "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg",
    title: "The Witcher",
    count: 2,
    score: 4.5,
  };

  // como capturar o parametro passado na chamado do formulario.????

  /// fim teste mocado

  let { idParam } = useParams<{ idParam: string }>();

  return (
    <div className="dsmovie-form-container">
      <h6>ID: {idParam}</h6>

      <img
        className="dsmovie-movie-card-image"
        src={movie.image}
        alt={movie.title}
      />
      {console.log("FormCard-->Avaliacao do filmeOK: " + movie.id)}

      {console.log("FormCard-->Avaliacao do filmexx: " + idParam)}

      <div className="dsmovie-card-bottom-container">
        <h3>{movie.title}</h3>

        <form className="dsmovie-form">
          <div className="form-group dsmovie-form-group">
            <label htmlFor="email">Informe seu email</label>
            <input type="email" className="form-control" id="email" />
          </div>
          <div className="form-group dsmovie-form-group">
            <label htmlFor="score">Informe sua avaliação</label>
            <select className="form-control" id="score">
              <option>1</option>
              <option>2</option>
              <option>3</option>
              <option>4</option>
              <option>5</option>
            </select>
          </div>

          <div className="dsmovie-form-btn-container">
            <button type="submit" className="btn btn-primary dsmovie-btn">
              Salvar
            </button>
          </div>
        </form>
        <Link to="/pagina07">
          <button className="btn btn-primary dsmovie-btn mt-3">Cancelar</button>
        </Link>
      </div>
    </div>
  );
}

export default FormCard;
