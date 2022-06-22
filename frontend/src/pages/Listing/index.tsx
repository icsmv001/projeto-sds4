import axios from "axios";
import MovieCard from "components/MovieCard";
import Pagination2 from "components/Pagination2";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/requests";

function Listing() {
  const [pageNumber, setPageNumber] = useState(0);

  const [page, setPage] = useState<MoviePage>({
    content: [],
    last: true,
    totalPages: 0,
    totalElements: 0,
    size: 0,
    number: 0,
    first: true,
    numberOfElements: 0,
    empty: true,
  });

  useEffect(() => {
    axios
      .get(`${BASE_URL}/movies?size=12&page=${pageNumber}&sort=id`)
      .then((response) => {
        const data = response.data as MoviePage;
        setPage(data);
        // console.log(data);
        // setPageNumber(data.number);
      });
  }, [pageNumber]);

  // // INICIO -forma errada - para testar requisicao  -- ` <-- CRASE SIMPLES
  // axios.get(`${BASE_URL}/movies?size=12&page=0`).then((response) => {
  //   console.log(response.data);
  // });
  // // FIM  -forma errada - para testar requisicao  -- ` <-- CRASE SIMPLES

  return (
    <>
      <Pagination2 />

      <div className="container">
        <div className="row">
          {page.content.map((movie) => (
            <div key={movie.id} className="col-sm-6 col-lg-4 col-xl-3 mb-3">
              <MovieCard movie={movie} />
            </div>
          ))}
        </div>
      </div>
    </>
  );
}

export default Listing;
