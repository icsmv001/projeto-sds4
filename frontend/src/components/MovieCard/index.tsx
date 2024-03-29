import MovieScore from "components/MovieScore";
import { Link } from "react-router-dom";
import { Movie } from "types/movie";
//import  from "pages/Form";

type Props = {
  movie: Movie;
};

// const movie = {
//   id: 1,
//   image:
//     "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg",
//   title: "The Witcher",
//   count: 2,
//   score: 4.5,
// };

function MovieCard({ movie }: Props) {
  return (
    <div>
      <img
        className="dsmovie-movie-card-image"
        src={movie.image}
        alt={movie.title}
      />
      <div className="dsmovie-card-bottom-container">
        <h4>{movie.title}</h4>
        <MovieScore count={movie.count} score={movie.score} />

        <Link to={`/FormCard/${movie.id}`}>
          <div className="btn btn-primary dsmovie-btn">Avaliar</div>
          {console.log("MovieCard - teste valor do id do filme: " + movie.id)}
        </Link>
      </div>
    </div>
  );
}

export default MovieCard;
