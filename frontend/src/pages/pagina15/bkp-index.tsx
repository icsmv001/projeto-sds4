import Footer from "components/Footer";
import NavBar1 from "components/Navbar1";
import axios, { AxiosRequestConfig } from "axios";
//import PaginationSeller from "components/PaginationSeller";
import React, { useEffect, useState } from "react";
import { SellerPage } from "types/seller";
import { BASE_URL } from "utils/requests";
//import BannerSucess from "components/BannerSucess/BannerSucess";
import Swal from "sweetalert2";

function AlertaSucess() {
  Swal.fire({
    // position: "top-end",
    width: 350,
    icon: "success",
    title: "Cadastro Realizado Com Sucesso: ",
    showConfirmButton: false,
    timer: 1500,
  });
}

const Pagina14 = () => {
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
      .get(`${BASE_URL}/sellers?page=${activePage}&size=28&sort=id,asc`)
      .then((response) => {
        setpage(response.data);
      });
  }, [activePage]);

  // // funcao que recebe os argumentos de paginacao
  //  comentario em 08/05/2022 --- nova atualizacao
  const [cmbVendedor, setcmbVendedor] = useState([] as any);

  const [visited, setVisited] = useState([] as any);
  const [deals, setDeals] = useState([] as any);
  const [amount, setAmount] = useState([] as any);
  const [data, setData] = useState([] as any);
  //=======================================================

  //====================
  function handleCreate(e: { preventDefault: () => void }) {
    e.preventDefault();
    // atualizacao 10/03/2022
    // usando funcao split, para pegar parte do string separada por hifen
    // primeiro pego index 0, para pegar o id do vendedor
    // segundo  pego index 1, para pegar o nome do vendedor
    const IdVendedor = cmbVendedor.split("-", 1)[0];
    const NmVendedor = cmbVendedor.split("-", 2)[1];

    // alert(" IdVendedor..: " + IdVendedor);
    // alert(" NmVendedor..: " + NmVendedor);
    // alert(" Qt.Visitas: " + visited);
    // alert(" Tt.Venda Concluida: " + deals);
    // alert(" Tt.Venda Realizadas: " + amount);
    // alert(" data Cadastro: " + data);

    // console.log(
    //   " id do vendedor selecionado : " +
    //     IdVendedor +
    //     " ,Nome do vendedor selecionado : " +
    //     NmVendedor +
    //     " ,total visitas " +
    //     visited +
    //     " ,total vendas Concluidas " +
    //     deals +
    //     " ,Tt.Venda Realizadas: " +
    //     amount +
    //     " ,data Cadastro: " +
    //     data
    // );

    //  // json a ser montado para put na base
    //    {
    //         "visited": visited,
    //         "deals": deals,
    //         "amount": amount,
    //         "date": data,
    //         "seller": {
    //             "id": IdVendedor,
    //             "name": "NmVendedor"
    //         }
    //     }

    // atualizacao 10/03/2022 - adicionado chamada rest-metodo post
    // atualizado cadastro de vendas por vendedor.
    // envia dados do modelo json, para gravar no banco de dados .
    const config: AxiosRequestConfig = {
      baseURL: BASE_URL,
      method: "POST",
      url: "/sales/vendaNova/",
      data: {
        visited: visited,
        deals: deals,
        amount: amount,
        date: data,
        seller: {
          id: IdVendedor,
          name: NmVendedor,
        },
      },
    };

    axios(config).then((response) => {
      Array.from(document.querySelectorAll("input")).forEach(
        (input) => (input.value = "")
      );

      <option value="0">Selecione Nome Vendedor</option>;
      //-------------------------------------------------------
      const chkSucesso = response.status ? "Sucesso" : "Erro";
      //--------------------------------------------------------
      console.log(response.data);

      if (chkSucesso === "Sucesso") {
        AlertaSucess();
      } else {
        alert("Erro," && "Houve um erro inesperado: " + chkSucesso);
      }
    });
  }

  return (
    <>
      <NavBar1 />

      <div className="container formVendas">
        <div className="jumbotron">
          <h1 className="display-4">Cadastro de Estruturas 1.0</h1>
          <p className="container">
            <div className="row">
              {/* inicio tratamento listar nome vendedores */}
              <div className="input-fied col s3">
                <label className="ls-label col-md-2 ">
                  Vendedor:
                  <div className="ls-custom-select ">
                    <select
                      autoFocus
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
                  Qt. Visitas Realizadas:{" "}
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="visited"
                  id="visited"
                  placeholder="Quantidade Visitas Realizadas"
                  onChange={(texto) => setVisited(texto.target.value)}
                ></input>
              </div>

              <div className="input-fied col s3">
                <label className="col-xs-2 control-label">
                  Qt. Vendas Concluidas:{" "}
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="deals"
                  id="deals"
                  placeholder="Quantidade Vendas Concluidas"
                  onChange={(texto) => setDeals(texto.target.value)}
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
                  onChange={(texto) => setAmount(texto.target.value)}
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
                  onChange={(texto) => setData(texto.target.value)}
                ></input>
              </div>
            </div>
          </p>
          <hr />
          <div className="form-group text-center">
            <button
              onClick={handleCreate}
              className="btn btn-success"
              type="submit"
            >
              Salvar
            </button>
          </div>
        </div>
      </div>

      <Footer />
    </>
  );
};

export default Pagina14;
