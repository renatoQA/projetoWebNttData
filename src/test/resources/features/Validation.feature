#language:pt
#Author: Renato Bernardes


Funcionalidade:  Validar fluxo de um produto dentro do site Advantage Online Shopping

 Contexto:
    Dado que eu acesse o site

   @test #DONE
   Cenário: Validar especificações do produto

   Quando clicar em Special Offer
   E clicar em See offer
   Então validar a especificação do produto de acordo com o banco de dados

  @test
  Cenário: Validar alteração de cor do produto no carrinho

  Dado que eu acesse o site
  Quando clicar em Special Offer
  E clicar em See offer
  E altero a cor do produto de acordo com a cor retornada do banco de dados
  E clico em Add to cart
  Então valido que o produto foi adicionado ao carrinho com a cor selecionada

  @test
  Cenário: Validar página de checkout

  E tenha pesquisado o produto no icone da lupa conforme o banco de dados
  Quando altero a cor do produto
  E altero a quantidade que desejo comprar para 3
  E clico em Add to cart
  Então valido que  total na pagina de checkout
  E  realizo um update no banco da cor  do produto para a cor usada no teste

  @test
  Cenário: Remover produto do carrinho de compras

  Quando clicar em Special Offer
  E clicar em See offer
  E clico em Add to cart
  E removo o produto do carrinho de compras
  Então valido que o carrinho de compras está vazio
