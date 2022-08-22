import { Link } from "react-router-dom";
import "./styles.css";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { BASE_URL } from "utils/requests";
import { Movie } from "types/movie";
import { validateEmail } from "utils/validate";
import { AxiosRequestConfig } from "axios";
import axios from "axios";

//   <Route path="/FormCard/:idParam" component={FormCard}>
// ponto xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

function FormCard() {
  // componente FormCard, responsavel por renderizar o formulario do validacao de nota para o filme.

  /// objeto movie mocado, tras um mesmo resultado sempre, para teste
  // const movie = {
  //   id: 13,
  //   image:
  //     "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg",
  //   title: "The Witcher",
  //   count: 2,
  //   score: 4.5,
  // };

  // como capturar o parametro passado na chamado do formulario.????

  /// fim teste mocado

  /// teste pegando parametro passado na pagina via rota
  //let { idParam } = useParams<{ idParam: string }>();

  const params = useParams<{ idParam: string }>();
  const [movie, setMovie] = useState<Movie>();

  // chamada da api
  useEffect(() => {
    axios.get(`${BASE_URL}/movies/${params.idParam}`).then((Response) => {
      setMovie(Response.data);
    });
    // colocar o mesmo parametro nas dependencias do useEffect do FormCard,
    // deve ser o mesmo parametro, usado na passagem e chamada do axios.get,
    // se nao colocar a requisicao ocorre N vezes, e ao colocar somente
    // sera refeita se o parametro mudar..
  }, [params.idParam]);

  const handleSubmit = (event: { preventDefault: () => void; target: any }) => {
    event.preventDefault();

    const email = (event.target as any).email.value;
    const score = (event.target as any).score.value;

    if (!validateEmail(email)) {
      return;
    }

    //confuracoa de requisicao do axios, para fazer um put de insersao de dados de score
    const config: AxiosRequestConfig = {
      baseURL: BASE_URL,
      method: "PUT",
      url: "/scores",
      data: {
        movieID: params.idParam,
        email: email,
        score: score,
      },
    };
    console.log("teste retorno movieId :" + params.idParam);
    console.log("teste retorno variaveis : " + email, score);

    axios(config).then((response) => {
      console.log(response.data);
    });
  };

  return (
    <div className="dsmovie-form-container">
      <h6>ID: {params.idParam}</h6>

      <img
        className="dsmovie-movie-card-image"
        src={movie?.image}
        alt={movie?.title}
      />
      {console.log("FormCard-->Avaliacao do filmeOK: " + movie?.id)}

      {console.log("FormCard-->Avaliacao do filmexx: " + params.idParam)}

      <div className="dsmovie-card-bottom-container">
        <h3>{movie?.title}</h3>

        <form className="dsmovie-form" onSubmit={handleSubmit}>
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
