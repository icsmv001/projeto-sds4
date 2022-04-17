import Footer from "components/Footer";
import NavBar from "components/Navbar";
//
import axios from "axios";
import PaginationSeller from "components/PaginationSeller";
import React, { useEffect, useState } from "react";
import { SellerPage } from "types/seller";
import { BASE_URL } from "utils/requests";

const Pagina04 = () => {
  // inicio teste

  // /// inicio estado anterior...
  // const [estado] = useState(1);

  // const editarEstado = (e: { preventDefault: () => void }) => {
  //   e.preventDefault();
  //   alert("Id do Estado: " + estado);
  // };

  const [activePage, setActivePage] = useState(0);

  const [page, setpage] = useState<SellerPage>({
    first: true,
    last: true,
    number: 0,
    totalElements: 0,
    totalPages: 0,
  });

  const options = [page, setpage];

  // chamada da api
  useEffect(() => {
    //axios.get("http://localhost:8080/sales?page=0&size=10&sort=date,desc")

    axios.get(`${BASE_URL}/sellers?sort=id`).then((response) => {
      setpage(response.data);
    });
  }, [activePage]);

  // // funcao que recebe os argumentos de paginacao
  // const changePage = (index: number) => {
  //   setActivePage(index);
  // };

  const [estados, setEstados] = useState([]);

  useEffect(() => {
    axios.get(`${BASE_URL}/sellers?sort=id`).then((response) => {
      setEstados(response.data);
    });
  }, []);

  return (
    <>
      <NavBar />

      <div className="container formVendas">
        <div className="jumbotron">
          <h1 className="display-4">Cadastro de Vendas</h1>
          <p className="container">
            <div className="row">
              {/* inicio tratamento listar nome vendedores */}

              <div className="input-fied col s3">
                <label className="col-xs-2 control-label">
                  <select name="cmbVendedor" id="cmbVendedor">
                    <option value="0">Selecione uma opção</option>
                    {page.content?.map((item) => (
                      <option key={item.id} value={item.id}>
                        {item.id} {item.name}
                      </option>
                    ))}
                  </select>{" "}
                </label>

                <input
                  type="text"
                  className="form-control"
                  name="nome"
                  placeholder="Digite Nome Vendedor"
                ></input>
              </div>

              {/* inicio tratamento listar nome vendedores */}

              <div className="input-fied col s3">
                <label className="col-xs-2 control-label">
                  Quantidade Visitas Realizadas:{" "}
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="visited"
                  placeholder="Quantidade Visitas Realizadas"
                ></input>
              </div>

              <div className="input-fied col s3">
                <label className="col-xs-2 control-label">
                  Quantidade Vendas Concluidas:{" "}
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="deals"
                  placeholder="Quantidade Vendas Concluidas"
                ></input>
              </div>
            </div>
          </p>
          <hr />

          <p className="container1">
            <div className="row">
              <div className="input-fied col s3">
                <label className="col-xs-2 control-label">
                  Valor Total Vendas Realizadas:{" "}
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="amount"
                  placeholder="Valor Total Vendas Realizadas"
                ></input>
              </div>

              <div className="input-fied col s3">
                <label className="col-xs-2 control-label">Data: </label>
                <input
                  type="date"
                  className="form-control"
                  name="data"
                  placeholder="Digite data Evento"
                ></input>
              </div>
            </div>
          </p>
          <hr />

          <button className="btn btn-success" type="submit">
            Salvar
          </button>
        </div>
      </div>

      {/* <div className="container formVendasteste" onSubmit={editarEstado}>
        <h6> editar com campo select </h6>
        <label> Estado</label>
        <select name="estado" value={estado}>
          <option value="">Selecione</option>
          <option value="1"> SP</option>
          <option value="2"> RJ</option>
          <option value="3"> MG</option>
          <option value="4"> PR</option>
        </select>
      </div> */}

      <div>
        <h6> ******************* </h6>
        <div>
          <label>
            VENDEDOR:
            <select name="cmbVendedor" id="cmbVendedor">
              <option value="0">Selecione uma opção</option>
              {page.content?.map((item) => (
                <option key={item.id} value={item.id}>
                  {item.id} {item.name}
                </option>
              ))}
            </select>
          </label>
        </div>
      </div>

      <Footer />
    </>
  );
};

export default Pagina04;
