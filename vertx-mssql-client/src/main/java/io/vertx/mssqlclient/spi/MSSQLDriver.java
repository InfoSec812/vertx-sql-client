/*
 * Copyright (C) 2020 IBM Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.vertx.mssqlclient.spi;

import io.vertx.core.Vertx;
import io.vertx.mssqlclient.MSSQLConnectOptions;
import io.vertx.mssqlclient.MSSQLPool;
import io.vertx.sqlclient.Pool;
import io.vertx.sqlclient.PoolConfig;
import io.vertx.sqlclient.SqlConnectOptions;
import io.vertx.sqlclient.spi.Driver;

public class MSSQLDriver implements Driver {

  @Override
  public Pool createPool(PoolConfig config) {
    return MSSQLPool.pool(MSSQLConnectOptions.wrap(config.baseConnectOptions()), config.options());
  }

  @Override
  public Pool createPool(Vertx vertx, PoolConfig config) {
    return MSSQLPool.pool(vertx, MSSQLConnectOptions.wrap(config.baseConnectOptions()), config.options());
  }

  @Override
  public boolean acceptsOptions(SqlConnectOptions options) {
    return options instanceof MSSQLConnectOptions || SqlConnectOptions.class.equals(options.getClass());
  }
}
