package core.peer;

import core.Pc365Exception;
import core.TransactionProcessor;
import core.util.JSON;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

final class ProcessTransactions implements PeerServlet.PeerRequestHandler {

  private final TransactionProcessor transactionProcessor;

  ProcessTransactions(TransactionProcessor transactionProcessor) {
    this.transactionProcessor = transactionProcessor;
  }


  @Override
  public JsonElement processRequest(JsonObject request, Peer peer) {

    try {
      transactionProcessor.processPeerTransactions(request, peer);
      return JSON.emptyJSON;
    } catch (RuntimeException | Pc365Exception.ValidationException e) {
      peer.blacklist(e, "received invalid data via requestType=processTransactions");
      JsonObject response = new JsonObject();
      response.addProperty("error", e.toString());
      return response;
    }
  }
}
