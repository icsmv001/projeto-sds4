import Footer from "components/Footer";
import NavBar from "components/navbar";
import React from "react";

const Pagina03 = () => {
  return (
    <>
      <NavBar />

      <div className="container formVendas">
        <div className="jumbotron">
          <h1 className="display-4">Cadastro de Vendedor</h1>
          <p className="container">
            <div className="row">
              <div className="input-fied col s3">
                <label className="col-xs-2 control-label">Vendedor: </label>
                <input
                  type="text"
                  className="form-control"
                  name="nome"
                  placeholder="Digite Nome Vendedor"
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

          <p className="container1">
            <div className="row"></div>
          </p>

          <button className="btn btn-success" type="submit">
            Salvar
          </button>
        </div>
      </div>
      <Footer />
    </>
  );
};

export default Pagina03;
