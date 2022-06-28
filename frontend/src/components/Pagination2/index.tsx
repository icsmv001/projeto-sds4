import { ReactComponent as Arrow } from "assets/img/arrow.svg";
import { MoviePage } from "types/movie";
import "./styles.css";

//20220627, criando typo props para receber o tipo moviePage e uma funcao onChange, para o evento click
// para quando clicar capturar a solicitacao de mudanca de pagina, passar como parametro
// e mover a paginacao por uma nova requisicao, com numero da pagina solicitada.

type Props = {
  page: MoviePage;
  onChange: Function;
};

function Pagination2({ page, onChange }: Props) {
  return (
    <div className="dsmovie-pagination2-container">
      <div className="dsmovie-pagination2-box">
        <button
          className="dsmovie-pagination2-button"
          disabled={page.first}
          onClick={() => onChange(page.number - 1)}
        >
          <Arrow />
        </button>
        <p>{`${page.number + 1} de ${page.totalPages}`}</p>
        <button
          className="dsmovie-pagination2-button"
          disabled={page.last}
          onClick={() => onChange(page.number + 1)}
        >
          <Arrow className="dsmovie-flip-horizontal" />
        </button>
      </div>
    </div>
  );
}

export default Pagination2;
