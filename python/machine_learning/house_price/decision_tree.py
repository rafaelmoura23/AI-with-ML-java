from sklearn.datasets import fetch_openml
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeRegressor
from sklearn.metrics import mean_squared_error, r2_score

# Baixando o dataset de preços de casas do OpenML
housing = fetch_openml(name="house_prices", as_frame=True)

# Extraindo os dados e o alvo
data = housing.data
target = housing.target

# Combinando os dados e o alvo em um único DataFrame
df = pd.concat([data, target], axis=1)

# Exibindo informações sobre o dataset
print(df.info())
print(df.describe())

# Adicionando a coluna 'SalePrice' ao DataFrame
df['SalePrice'] = target


# Selecionando as melhores features
features = ['OverallQual', 'GrLivArea', 'GarageCars']
X = df[features]
y = df['SalePrice']

# Dividindo os dados em treino e teste


X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)



# Instanciando o modelo
modelo_arvore = DecisionTreeRegressor(random_state=42)

# Treinando o modelo
modelo_arvore.fit(X_train, y_train)

# Fazendo previsões no conjunto de teste
y_pred = modelo_arvore.predict(X_test)

# Avaliando o modelo
mse = mean_squared_error(y_test, y_pred)
r2 = r2_score(y_test, y_pred)

print(f"Árvore de Decisão - Erro Quadrático Médio: {mse:.2f}")
print(f"Árvore de Decisão - R²: {r2:.2f}")

# Criando um DataFrame para comparar valores reais e previstos
resultado = pd.DataFrame({'Valor Real': y_test, 'Previsão': y_pred})

# Exibindo as 10 primeiras comparações
print(resultado.head(10))
