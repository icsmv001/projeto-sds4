import { Seller } from "./seller";
//venda
export type Sale = {
  id: number;
  visited: number;
  deals: number;
  amount: number;
  date: string;
  seller: Seller;
};

export type SalePage = {
  content?: Sale[];
  last: boolean;
  totalElements: number;
  totalPages: number;
  size?: number;
  number: number;
  first: boolean;
  numberOfElements?: number;
  empty?: boolean;
};

// definir tipo de objeto que recebe os dados do servico backend de get {host}}/sales/amount-by-seller
// que é a soma das vendas por vendedor, ou representacao do DTO do backend

export type SaleSum = {
  sellerName: string;
  sum: number;
};

export type SaleSuccess = {
  sellerName: string;
  visited: number;
  deals: number;
};

// sales
export type Sales = {
  id: number;
  visited: number;
  deals: number;
  amount: number;
  date: string;
  seller: Seller[];
};
