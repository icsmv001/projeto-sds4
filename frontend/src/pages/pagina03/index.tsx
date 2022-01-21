import Footer from "components/Footer";
import NavBar from "components/navbar";
import React from "react";

const Pagina03 = () => {
  const handleSubmit = (event: { preventDefault: () => void; target: any }) => {
    event.preventDefault();
    const NmVendedor1 = (event.target as any).NmVendedor1.value;
    const datacadastro = (event.target as any).datacadastro.value;

    console.log(NmVendedor1, datacadastro);
  };

  return (
    <>
      <form className=" container formVendas" onSubmit={handleSubmit}>
        <NavBar />

        {/* <div className="jumbotron">
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

              <label htmlFor="NmVendedor">Digite Nome Vendedor:</label>
              <input
                type="NmVendedor"
                className="form-control"
                id="NmVendedor1"
                placeholder="Digite Nome Vendedor"
              />
            </div>
          </p>

          <p className="container1">
            <div className="row"></div>
          </p>

          <button type="submit" className="btn btn-success">
            Salvar
          </button>
        </div> */}

        <h1 className="display-4">Cadastro de Vendedor</h1>

        <div className="teste">
          <label htmlFor="NmVendedor">Digite Nome Vendedor:</label>
          <input
            type="NmVendedor1"
            className="form-control"
            id="NmVendedor1"
            placeholder="Digite Nome Vendedor"
          ></input>

          <label className="col-xs-2 control-label">Data: </label>
          <input
            type="date"
            className="form-control"
            id="datacadastro"
            placeholder="Digite data Evento"
          ></input>

          <button type="submit" className="btn btn-success">
            Salvar
          </button>
        </div>
      </form>
      <Footer />
    </>
  );
};

export default Pagina03;
