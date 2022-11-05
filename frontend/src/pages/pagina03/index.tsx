import { AxiosRequestConfig } from "axios";
import axios from "axios";
import Footer from "components/Footer";
import NavBar1 from "components/Navbar1";
import React from "react";
import { BASE_URL } from "utils/requests";
import { validateEmail } from "utils/validate";
// import { validateEmail } from "utils/validate";
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

const Pagina03 = () => {
  const handleSubmit = (event: { preventDefault: () => void; target: any }) => {
    event.preventDefault();
    const NmVendedor1 = (event.target as any).NmVendedor1.value;
    const Email = (event.target as any).Email.value;
    const datacadastro = (event.target as any).datacadastro.value;

    if (!validateEmail(Email)) {
      return;
    }

    const config: AxiosRequestConfig = {
      baseURL: BASE_URL,
      method: "POST",
      url: "/sellers/vendedor",
      data: {
        name: NmVendedor1,
        email: Email,
        datacadastro: datacadastro,
      },
    };

    axios(config).then((response) => {
      Array.from(document.querySelectorAll("input")).forEach(
        (input) => (input.value = "")
      );

      //console.log(response.data);
      //alert("Sucesso!," && "Cadastro Realizado Com Sucesso");
      const chkSucesso = response.status ? "Sucesso" : "Erro";
      //--------------------------------------------------------
      console.log(response.data);

      if (chkSucesso === "Sucesso") {
        AlertaSucess();
      } else {
        alert("Erro," && "Houve um erro inesperado: " + chkSucesso);
      }
    });

    // console.log(NmVendedor1, datacadastro, Email);

    // console.log(NmVendedor1);
  };

  return (
    <>
      <div className="card">
        <div className="card-body"></div>
        <form className=" container formVendas" onSubmit={handleSubmit}>
          <NavBar1 />

          <div className="jumbotron">
            <h1 className="display-4">Cadastro de Vendedor</h1>

            <p className="container">
              <div className="row">
                <div className="input-fied col s3">
                  <label className="col-xs-2 control-label">
                    Digite Nome Vendedor:
                  </label>
                  <textarea
                    id="NmVendedor11"
                    className="form-control"
                    placeholder="Digite Nome Vendedor:"
                  ></textarea>
                </div>

                <div className="input-fied col s3">
                  <label className="col-xs-2 control-label">
                    Digite Email Vendedor:
                  </label>

                  <input
                    type="email"
                    className="form-control"
                    id="Email"
                    placeholder="Digite Email Vendedor"
                  ></input>
                </div>
                <div className="input-fied col s3">
                  <label className="col-xs-2 control-label">
                    Data Cadastro:
                  </label>

                  <input
                    type="date"
                    className="form-control"
                    id="datacadastro"
                    placeholder="Digite data Evento"
                  ></input>
                </div>
              </div>

              <p className="container1">
                <div className="row"></div>
              </p>

              <div className="form-group text-center">
                <button type="submit" className="btn btn-success">
                  Salvar
                </button>
              </div>
            </p>
          </div>
        </form>
      </div>

      <div className="form-group text-center">cadastro</div>

      <Footer />
    </>
  );
};

export default Pagina03;
