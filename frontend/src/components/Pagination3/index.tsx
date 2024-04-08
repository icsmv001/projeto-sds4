import { LogProcessoPage } from "types/LogProcesso";

// 20220627 - criado typo Props de propriedades para receber paginacao e tipo  salepage.

type Props = {
  page: LogProcessoPage;
  onPageChange: Function;
};

const Pagination3 = ({ page, onPageChange }: Props) => {
  return (
    <div className="row d-flex justify-content-center">
      <nav>
        <ul className="pagination">
          <li className={`page-item ${page.first ? `disabled` : ``}`}>
            <button
              className="page-link"
              onClick={() => onPageChange(page.number - 1)}
            >
              {" "}
              Anterior{" "}
            </button>
          </li>
          <li className="page-item disabled">
            <span className="page-link">{page.number + 1}</span>
          </li>
          <li className={`page-item ${page.last ? `disabled` : ``}`}>
            <button
              className="page-link"
              onClick={() => onPageChange(page.number + 1)}
            >
              Próxima
            </button>
          </li>
        </ul>
      </nav>
    </div>
  );
};

export default Pagination3;
