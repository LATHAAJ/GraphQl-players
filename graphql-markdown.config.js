module.exports = {
  schema: "./src/main/resources/graphql/schema.graphqls", // path to your GraphQL schema
  output: "./docs",                                      // where Markdown files will be generated
  loaders: {
    GraphQLFileLoader: "@graphql-tools/graphql-file-loader"
  }
};
