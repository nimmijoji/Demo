# Cucumber Regression tests Execution Commands

### Production environment
APAC - `@WebRegression and @live and not @eu and not @nwk`
EU - `@WebRegression and @live and not @apac and not @nwk`
US - `@WebRegression and @live and not apac and not @eu`

### Non-Production environment
APAC - `@WebRegression and not @eu and not @nwk`
EU - `@WebRegression and not @apac and not @nwk`
US - `@WebRegression and not @apac and not @eu`