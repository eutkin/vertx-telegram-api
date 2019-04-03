package io.github.eutkin.telegram.request;

import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.MultiMap;

public interface Command {

  JsonObject toJson();

  default MultiMap toMap() {
    return toJson()
      .stream()
      .reduce(
        MultiMap.caseInsensitiveMultiMap(),
        (m, e) -> m.add(e.getKey(), String.valueOf(e.getValue())),
        MultiMap::addAll
      );
  }

  default String getTelegramMethod() {
    String name = getClass().getSimpleName();
    String s = name.replaceFirst("Command$", "");
    return s.substring(0, 1).toLowerCase() + s.substring(1);
  }
}
