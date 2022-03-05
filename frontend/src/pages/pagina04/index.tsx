import Footer from "components/Footer";
import NavBar from "components/navbar";
//
import axios from "axios";
import PaginationSeller from "components/PaginationSeller";
import React, { useEffect, useState } from "react";
import { SellerPage } from "types/seller";
import { BASE_URL } from "utils/requests";

const Pagina04 = () => {
  const [activePage] = useState(0);

  const [page, setpage] = useState<SellerPage>({
    first: true,
    last: true,
    number: 0,
    totalElements: 0,
    totalPages: 0,
  });

  // chamada da api
  useEffect(() => {
    axios
      .get(`${BASE_URL}/sellers?page=${activePage}&size=28&sort=id,desc`)
      .then((response) => {
        setpage(response.data);
      });
  }, [activePage]);

  // // funcao que recebe os argumentos de paginacao
  const [cmbVendedor, setcmbVendedor] = useState([] as any);
  const [visited, setvisited] = useState([] as any);
  const [deals, setdeals] = useState([] as any);
  const [amount, setamount] = useState([] as any);
  const [data, setdata] = useState([] as any);

  function handleCreate(e: { preventDefault: () => void }) {
    e.preventDefault();
    alert(" Vendedor..: " + cmbVendedor);
    alert(" Qt.Visitas: " + visited);
    alert(" Tt.Venda Concluida: " + deals);
    alert(" Tt.Venda Realizadas: " + amount);
    alert(" data Cadastro: " + data);

    console.log(
      " id e nome selecionado : " +
        cmbVendedor +
        " total visitas " +
        visited +
        " total vendas Concluidas " +
        deals +
        " Tt.Venda Realizadas: " +
        amount +
        " data Cadastro: " +
        data
    );
  }

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
                <label className="ls-label col-md-2 ">
                  Vendedor:
                  <div className="ls-custom-select ">
                    <select
                      style={{ width: 280, height: 35, top: 10 }}
                      onChange={(texto) => setcmbVendedor(texto.target.value)}
                    >
                      <option value="0">Selecione Nome Vendedor</option>

                      {page.content?.map((item) => (
                        <option key={item.id} value={item.id + "-" + item.name}>
                          {item.id} {item.name}
                        </option>
                      ))}
                    </select>
                  </div>
                </label>
              </div>
              {/* termino tratamento listar nome vendedores */}
              <div className="input-fied col s3">
                <label className="col-xs-2 control-label">
                  Quantidade Visitas Realizadas:{" "}
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="visited"
                  id="visited"
                  placeholder="Quantidade Visitas Realizadas"
                  onChange={(texto) => setvisited(texto.target.value)}
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
                  id="deals"
                  placeholder="Quantidade Vendas Concluidas"
                  onChange={(texto) => setdeals(texto.target.value)}
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
                  id="amount"
                  placeholder="Valor Total Vendas Realizadas"
                  onChange={(texto) => setamount(texto.target.value)}
                ></input>
              </div>

              <div className="input-fied col s3">
                <label className="col-xs-2 control-label">Data: </label>
                <input
                  type="date"
                  className="form-control"
                  name="data"
                  id="data"
                  placeholder="Digite data Evento"
                  onChange={(texto) => setdata(texto.target.value)}
                ></input>
              </div>
            </div>
          </p>
          <hr />

          <button
            onClick={handleCreate}
            className="btn btn-success"
            type="submit"
          >
            Salvar
          </button>
        </div>
      </div>

      <Footer />
    </>
  );
};

export default Pagina04;
