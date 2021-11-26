// definir tipo de objeto que recebe os dados do servico backend de get {host}}/sales/amount-by-seller
// que é a soma das vendas por vendedor, ou representacao do DTO do backend
export type SaleSum = {
  sum: number;
  sellerName: string;
};
