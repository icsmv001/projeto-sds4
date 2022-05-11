import Footer from "components/Footer";
import NavBar1 from "components/Navbar1";
import axios from "axios";
import React, { useEffect, useState } from "react";
import { BASE_URL } from "utils/requests";

const Pagina05 = () => {
  const [vendedores, setvendedores] = useState([]);

  // chamada da api
  useEffect(() => {
    axios.get(`${BASE_URL}/sellers/vendedores`).then((response) => {
      setvendedores(response.data);
    });
  }, [vendedores]);

  // funcao que recebe o retorno do conteudo do item selecionado
  const [cmbVendedores, setcmbVendedores] = useState([] as any);

  function handleCreate(e: { preventDefault: () => void }) {
    e.preventDefault();
    // atualizacao 21/03/2022
    // pega o retorno do item selecionado, da funcao cmbvendedores e
    // usa a funcao split, para pegar parte do string separada por hifen
    // primeiro pega index 0, para pegar o id do vendedor
    // segundo  pega index 1, para pegar o nome do vendedor
    const IdVendedor = cmbVendedores.split("-", 1)[0];
    const NmVendedor = cmbVendedores.split("-", 2)[1];

    // display de tela com os valores retornados da selecao, para teste de mesa.
    alert(" IdVendedor..: " + IdVendedor);
    console.log(" IdVendedor..: " + IdVendedor);
    alert(" NmVendedor..: " + NmVendedor);
    console.log(" NmVendedor..: " + NmVendedor);
  }

  return (
    <>
      <NavBar1 />

      <div className="container formVendas">
        <div className="jumbotron">
          <h1 className="display-4">Cadastro de Vendas2.01</h1>
          <p className="container">
            <div className="row">
              {/* inicio tratamento listar nome vendedores */}
              <div className="input-fied col s3">
                <label className="ls-label col-md-2 ">
                  Vendedor:
                  <div className="ls-custom-select ">
                    <select
                      style={{ width: 280, height: 35, top: 10 }}
                      onChange={(texto) => setcmbVendedores(texto.target.value)}
                    >
                      <option value="0">Selecione uma opção</option>
                      {vendedores.map((item: any) => (
                        <option key={item} value={item.id + "-" + item.name}>
                          {item.id} {item.name}
                        </option>
                      ))}
                    </select>
                  </div>
                </label>
              </div>
            </div>
            {/* termino tratamento listar nome vendedores */}
          </p>
          <hr />

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

export default Pagina05;
