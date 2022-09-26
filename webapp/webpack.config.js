const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const path = require('path');
const CopyPlugin = require('copy-webpack-plugin');

pageTemplate = (options) => {
  return new HtmlWebpackPlugin({
    template: path.resolve(__dirname, options.path),
    chunks: ['styles'],
    minify: false,
    appMountId: 'app',
    filename: options.dist
  });
};


const config = {
  mode: 'development',
  entry: {
    index: './src/ts/index.ts',
    styles: './src/scss/styles.scss'
  },
  output: {
    path: path.resolve(__dirname, '../src/main/resources/dist/'),
    filename: 'bundle-[name].js',
    publicPath: '/'
  },
  module: {
    rules: [
      {
        test: /\.ts(x)?$/,
        use: [
          'awesome-typescript-loader'
        ],
        exclude: /node_modules/
      },
      {
        test: /\.(sa|sc|c)ss$/,
        use: [
          MiniCssExtractPlugin.loader,
          'css-loader',
          'sass-loader'
        ]
      }
    ]
  },
  resolve: {
    extensions: [
      '.tsx',
      '.ts',
      '.js'
    ]
  },
  plugins: [
    new CopyPlugin([
      { from: './src/assets', to: 'assets' }
    ]),
    new MiniCssExtractPlugin({
      filename: 'main-[name].css'
    }),
    pageTemplate({path: 'src/index.ftl', dist: '../dist/templates/index.ftl'}),
    pageTemplate({path: 'src/components/deleteModal.ftl', dist: '../dist/templates/components/deleteModal.ftl'}),
    pageTemplate({path: 'src/components/informationBookModal.ftl', dist: '../dist/templates/components/informationBookModal.ftl'})
  ]
};

module.exports = config;