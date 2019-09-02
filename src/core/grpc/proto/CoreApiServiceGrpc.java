package core.grpc.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.*;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.*;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.21.0)",
    comments = "Source: coreApi.proto")
public final class CoreApiServiceGrpc {

  private CoreApiServiceGrpc() {}

  public static final String SERVICE_NAME = "CoreApiService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.BasicTransaction,
      core.grpc.proto.CoreApi.TransactionBroadcastResult> getBroadcastTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BroadcastTransaction",
      requestType = core.grpc.proto.CoreApi.BasicTransaction.class,
      responseType = core.grpc.proto.CoreApi.TransactionBroadcastResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.BasicTransaction,
      core.grpc.proto.CoreApi.TransactionBroadcastResult> getBroadcastTransactionMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.BasicTransaction, core.grpc.proto.CoreApi.TransactionBroadcastResult> getBroadcastTransactionMethod;
    if ((getBroadcastTransactionMethod = CoreApiServiceGrpc.getBroadcastTransactionMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getBroadcastTransactionMethod = CoreApiServiceGrpc.getBroadcastTransactionMethod) == null) {
          CoreApiServiceGrpc.getBroadcastTransactionMethod = getBroadcastTransactionMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.BasicTransaction, core.grpc.proto.CoreApi.TransactionBroadcastResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "BroadcastTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.BasicTransaction.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.TransactionBroadcastResult.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("BroadcastTransaction"))
                  .build();
          }
        }
     }
     return getBroadcastTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.TransactionBytes,
      core.grpc.proto.CoreApi.TransactionBroadcastResult> getBroadcastTransactionBytesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BroadcastTransactionBytes",
      requestType = core.grpc.proto.CoreApi.TransactionBytes.class,
      responseType = core.grpc.proto.CoreApi.TransactionBroadcastResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.TransactionBytes,
      core.grpc.proto.CoreApi.TransactionBroadcastResult> getBroadcastTransactionBytesMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.TransactionBytes, core.grpc.proto.CoreApi.TransactionBroadcastResult> getBroadcastTransactionBytesMethod;
    if ((getBroadcastTransactionBytesMethod = CoreApiServiceGrpc.getBroadcastTransactionBytesMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getBroadcastTransactionBytesMethod = CoreApiServiceGrpc.getBroadcastTransactionBytesMethod) == null) {
          CoreApiServiceGrpc.getBroadcastTransactionBytesMethod = getBroadcastTransactionBytesMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.TransactionBytes, core.grpc.proto.CoreApi.TransactionBroadcastResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "BroadcastTransactionBytes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.TransactionBytes.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.TransactionBroadcastResult.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("BroadcastTransactionBytes"))
                  .build();
          }
        }
     }
     return getBroadcastTransactionBytesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.BasicTransaction,
      core.grpc.proto.CoreApi.BasicTransaction> getCompleteBasicTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompleteBasicTransaction",
      requestType = core.grpc.proto.CoreApi.BasicTransaction.class,
      responseType = core.grpc.proto.CoreApi.BasicTransaction.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.BasicTransaction,
      core.grpc.proto.CoreApi.BasicTransaction> getCompleteBasicTransactionMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.BasicTransaction, core.grpc.proto.CoreApi.BasicTransaction> getCompleteBasicTransactionMethod;
    if ((getCompleteBasicTransactionMethod = CoreApiServiceGrpc.getCompleteBasicTransactionMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getCompleteBasicTransactionMethod = CoreApiServiceGrpc.getCompleteBasicTransactionMethod) == null) {
          CoreApiServiceGrpc.getCompleteBasicTransactionMethod = getCompleteBasicTransactionMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.BasicTransaction, core.grpc.proto.CoreApi.BasicTransaction>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "CompleteBasicTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.BasicTransaction.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.BasicTransaction.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("CompleteBasicTransaction"))
                  .build();
          }
        }
     }
     return getCompleteBasicTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest,
      core.grpc.proto.CoreApi.Account> getGetAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccount",
      requestType = core.grpc.proto.CoreApi.GetAccountRequest.class,
      responseType = core.grpc.proto.CoreApi.Account.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest,
      core.grpc.proto.CoreApi.Account> getGetAccountMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest, core.grpc.proto.CoreApi.Account> getGetAccountMethod;
    if ((getGetAccountMethod = CoreApiServiceGrpc.getGetAccountMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetAccountMethod = CoreApiServiceGrpc.getGetAccountMethod) == null) {
          CoreApiServiceGrpc.getGetAccountMethod = getGetAccountMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAccountRequest, core.grpc.proto.CoreApi.Account>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Account.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAccount"))
                  .build();
          }
        }
     }
     return getGetAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest,
      core.grpc.proto.CoreApi.AccountATs> getGetAccountATsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccountATs",
      requestType = core.grpc.proto.CoreApi.GetAccountRequest.class,
      responseType = core.grpc.proto.CoreApi.AccountATs.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest,
      core.grpc.proto.CoreApi.AccountATs> getGetAccountATsMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest, core.grpc.proto.CoreApi.AccountATs> getGetAccountATsMethod;
    if ((getGetAccountATsMethod = CoreApiServiceGrpc.getGetAccountATsMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetAccountATsMethod = CoreApiServiceGrpc.getGetAccountATsMethod) == null) {
          CoreApiServiceGrpc.getGetAccountATsMethod = getGetAccountATsMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAccountRequest, core.grpc.proto.CoreApi.AccountATs>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAccountATs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.AccountATs.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAccountATs"))
                  .build();
          }
        }
     }
     return getGetAccountATsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountBlocksRequest,
      core.grpc.proto.CoreApi.Blocks> getGetAccountBlocksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccountBlocks",
      requestType = core.grpc.proto.CoreApi.GetAccountBlocksRequest.class,
      responseType = core.grpc.proto.CoreApi.Blocks.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountBlocksRequest,
      core.grpc.proto.CoreApi.Blocks> getGetAccountBlocksMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountBlocksRequest, core.grpc.proto.CoreApi.Blocks> getGetAccountBlocksMethod;
    if ((getGetAccountBlocksMethod = CoreApiServiceGrpc.getGetAccountBlocksMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetAccountBlocksMethod = CoreApiServiceGrpc.getGetAccountBlocksMethod) == null) {
          CoreApiServiceGrpc.getGetAccountBlocksMethod = getGetAccountBlocksMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAccountBlocksRequest, core.grpc.proto.CoreApi.Blocks>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAccountBlocks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAccountBlocksRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Blocks.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAccountBlocks"))
                  .build();
          }
        }
     }
     return getGetAccountBlocksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountOrdersRequest,
      core.grpc.proto.CoreApi.Orders> getGetAccountCurrentOrdersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccountCurrentOrders",
      requestType = core.grpc.proto.CoreApi.GetAccountOrdersRequest.class,
      responseType = core.grpc.proto.CoreApi.Orders.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountOrdersRequest,
      core.grpc.proto.CoreApi.Orders> getGetAccountCurrentOrdersMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountOrdersRequest, core.grpc.proto.CoreApi.Orders> getGetAccountCurrentOrdersMethod;
    if ((getGetAccountCurrentOrdersMethod = CoreApiServiceGrpc.getGetAccountCurrentOrdersMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetAccountCurrentOrdersMethod = CoreApiServiceGrpc.getGetAccountCurrentOrdersMethod) == null) {
          CoreApiServiceGrpc.getGetAccountCurrentOrdersMethod = getGetAccountCurrentOrdersMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAccountOrdersRequest, core.grpc.proto.CoreApi.Orders>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAccountCurrentOrders"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAccountOrdersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Orders.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAccountCurrentOrders"))
                  .build();
          }
        }
     }
     return getGetAccountCurrentOrdersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest,
      core.grpc.proto.CoreApi.EscrowTransactions> getGetAccountEscrowTransactionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccountEscrowTransactions",
      requestType = core.grpc.proto.CoreApi.GetAccountRequest.class,
      responseType = core.grpc.proto.CoreApi.EscrowTransactions.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest,
      core.grpc.proto.CoreApi.EscrowTransactions> getGetAccountEscrowTransactionsMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest, core.grpc.proto.CoreApi.EscrowTransactions> getGetAccountEscrowTransactionsMethod;
    if ((getGetAccountEscrowTransactionsMethod = CoreApiServiceGrpc.getGetAccountEscrowTransactionsMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetAccountEscrowTransactionsMethod = CoreApiServiceGrpc.getGetAccountEscrowTransactionsMethod) == null) {
          CoreApiServiceGrpc.getGetAccountEscrowTransactionsMethod = getGetAccountEscrowTransactionsMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAccountRequest, core.grpc.proto.CoreApi.EscrowTransactions>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAccountEscrowTransactions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.EscrowTransactions.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAccountEscrowTransactions"))
                  .build();
          }
        }
     }
     return getGetAccountEscrowTransactionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountsRequest,
      core.grpc.proto.CoreApi.Accounts> getGetAccountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccounts",
      requestType = core.grpc.proto.CoreApi.GetAccountsRequest.class,
      responseType = core.grpc.proto.CoreApi.Accounts.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountsRequest,
      core.grpc.proto.CoreApi.Accounts> getGetAccountsMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountsRequest, core.grpc.proto.CoreApi.Accounts> getGetAccountsMethod;
    if ((getGetAccountsMethod = CoreApiServiceGrpc.getGetAccountsMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetAccountsMethod = CoreApiServiceGrpc.getGetAccountsMethod) == null) {
          CoreApiServiceGrpc.getGetAccountsMethod = getGetAccountsMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAccountsRequest, core.grpc.proto.CoreApi.Accounts>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAccounts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAccountsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Accounts.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAccounts"))
                  .build();
          }
        }
     }
     return getGetAccountsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest,
      core.grpc.proto.CoreApi.Subscriptions> getGetAccountSubscriptionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccountSubscriptions",
      requestType = core.grpc.proto.CoreApi.GetAccountRequest.class,
      responseType = core.grpc.proto.CoreApi.Subscriptions.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest,
      core.grpc.proto.CoreApi.Subscriptions> getGetAccountSubscriptionsMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest, core.grpc.proto.CoreApi.Subscriptions> getGetAccountSubscriptionsMethod;
    if ((getGetAccountSubscriptionsMethod = CoreApiServiceGrpc.getGetAccountSubscriptionsMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetAccountSubscriptionsMethod = CoreApiServiceGrpc.getGetAccountSubscriptionsMethod) == null) {
          CoreApiServiceGrpc.getGetAccountSubscriptionsMethod = getGetAccountSubscriptionsMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAccountRequest, core.grpc.proto.CoreApi.Subscriptions>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAccountSubscriptions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Subscriptions.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAccountSubscriptions"))
                  .build();
          }
        }
     }
     return getGetAccountSubscriptionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountTransactionsRequest,
      core.grpc.proto.CoreApi.Transactions> getGetAccountTransactionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccountTransactions",
      requestType = core.grpc.proto.CoreApi.GetAccountTransactionsRequest.class,
      responseType = core.grpc.proto.CoreApi.Transactions.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountTransactionsRequest,
      core.grpc.proto.CoreApi.Transactions> getGetAccountTransactionsMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountTransactionsRequest, core.grpc.proto.CoreApi.Transactions> getGetAccountTransactionsMethod;
    if ((getGetAccountTransactionsMethod = CoreApiServiceGrpc.getGetAccountTransactionsMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetAccountTransactionsMethod = CoreApiServiceGrpc.getGetAccountTransactionsMethod) == null) {
          CoreApiServiceGrpc.getGetAccountTransactionsMethod = getGetAccountTransactionsMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAccountTransactionsRequest, core.grpc.proto.CoreApi.Transactions>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAccountTransactions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAccountTransactionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Transactions.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAccountTransactions"))
                  .build();
          }
        }
     }
     return getGetAccountTransactionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAliasRequest,
      core.grpc.proto.CoreApi.Alias> getGetAliasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAlias",
      requestType = core.grpc.proto.CoreApi.GetAliasRequest.class,
      responseType = core.grpc.proto.CoreApi.Alias.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAliasRequest,
      core.grpc.proto.CoreApi.Alias> getGetAliasMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAliasRequest, core.grpc.proto.CoreApi.Alias> getGetAliasMethod;
    if ((getGetAliasMethod = CoreApiServiceGrpc.getGetAliasMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetAliasMethod = CoreApiServiceGrpc.getGetAliasMethod) == null) {
          CoreApiServiceGrpc.getGetAliasMethod = getGetAliasMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAliasRequest, core.grpc.proto.CoreApi.Alias>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAlias"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAliasRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Alias.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAlias"))
                  .build();
          }
        }
     }
     return getGetAliasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAliasesRequest,
      core.grpc.proto.CoreApi.Aliases> getGetAliasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAliases",
      requestType = core.grpc.proto.CoreApi.GetAliasesRequest.class,
      responseType = core.grpc.proto.CoreApi.Aliases.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAliasesRequest,
      core.grpc.proto.CoreApi.Aliases> getGetAliasesMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAliasesRequest, core.grpc.proto.CoreApi.Aliases> getGetAliasesMethod;
    if ((getGetAliasesMethod = CoreApiServiceGrpc.getGetAliasesMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetAliasesMethod = CoreApiServiceGrpc.getGetAliasesMethod) == null) {
          CoreApiServiceGrpc.getGetAliasesMethod = getGetAliasesMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAliasesRequest, core.grpc.proto.CoreApi.Aliases>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAliases"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAliasesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Aliases.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAliases"))
                  .build();
          }
        }
     }
     return getGetAliasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest,
      core.grpc.proto.CoreApi.Asset> getGetAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAsset",
      requestType = core.grpc.proto.CoreApi.GetByIdRequest.class,
      responseType = core.grpc.proto.CoreApi.Asset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest,
      core.grpc.proto.CoreApi.Asset> getGetAssetMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest, core.grpc.proto.CoreApi.Asset> getGetAssetMethod;
    if ((getGetAssetMethod = CoreApiServiceGrpc.getGetAssetMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetAssetMethod = CoreApiServiceGrpc.getGetAssetMethod) == null) {
          CoreApiServiceGrpc.getGetAssetMethod = getGetAssetMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetByIdRequest, core.grpc.proto.CoreApi.Asset>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAsset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Asset.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAsset"))
                  .build();
          }
        }
     }
     return getGetAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAssetBalancesRequest,
      core.grpc.proto.CoreApi.AssetBalances> getGetAssetBalancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAssetBalances",
      requestType = core.grpc.proto.CoreApi.GetAssetBalancesRequest.class,
      responseType = core.grpc.proto.CoreApi.AssetBalances.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAssetBalancesRequest,
      core.grpc.proto.CoreApi.AssetBalances> getGetAssetBalancesMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAssetBalancesRequest, core.grpc.proto.CoreApi.AssetBalances> getGetAssetBalancesMethod;
    if ((getGetAssetBalancesMethod = CoreApiServiceGrpc.getGetAssetBalancesMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetAssetBalancesMethod = CoreApiServiceGrpc.getGetAssetBalancesMethod) == null) {
          CoreApiServiceGrpc.getGetAssetBalancesMethod = getGetAssetBalancesMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAssetBalancesRequest, core.grpc.proto.CoreApi.AssetBalances>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAssetBalances"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAssetBalancesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.AssetBalances.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAssetBalances"))
                  .build();
          }
        }
     }
     return getGetAssetBalancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAssetsRequest,
      core.grpc.proto.CoreApi.Assets> getGetAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAssets",
      requestType = core.grpc.proto.CoreApi.GetAssetsRequest.class,
      responseType = core.grpc.proto.CoreApi.Assets.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAssetsRequest,
      core.grpc.proto.CoreApi.Assets> getGetAssetsMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAssetsRequest, core.grpc.proto.CoreApi.Assets> getGetAssetsMethod;
    if ((getGetAssetsMethod = CoreApiServiceGrpc.getGetAssetsMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetAssetsMethod = CoreApiServiceGrpc.getGetAssetsMethod) == null) {
          CoreApiServiceGrpc.getGetAssetsMethod = getGetAssetsMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAssetsRequest, core.grpc.proto.CoreApi.Assets>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAssets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Assets.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAssets"))
                  .build();
          }
        }
     }
     return getGetAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest,
      core.grpc.proto.CoreApi.Assets> getGetAssetsByIssuerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAssetsByIssuer",
      requestType = core.grpc.proto.CoreApi.GetAccountRequest.class,
      responseType = core.grpc.proto.CoreApi.Assets.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest,
      core.grpc.proto.CoreApi.Assets> getGetAssetsByIssuerMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest, core.grpc.proto.CoreApi.Assets> getGetAssetsByIssuerMethod;
    if ((getGetAssetsByIssuerMethod = CoreApiServiceGrpc.getGetAssetsByIssuerMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetAssetsByIssuerMethod = CoreApiServiceGrpc.getGetAssetsByIssuerMethod) == null) {
          CoreApiServiceGrpc.getGetAssetsByIssuerMethod = getGetAssetsByIssuerMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAccountRequest, core.grpc.proto.CoreApi.Assets>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAssetsByIssuer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Assets.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAssetsByIssuer"))
                  .build();
          }
        }
     }
     return getGetAssetsByIssuerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAssetTransfersRequest,
      core.grpc.proto.CoreApi.AssetTrades> getGetAssetTradesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAssetTrades",
      requestType = core.grpc.proto.CoreApi.GetAssetTransfersRequest.class,
      responseType = core.grpc.proto.CoreApi.AssetTrades.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAssetTransfersRequest,
      core.grpc.proto.CoreApi.AssetTrades> getGetAssetTradesMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAssetTransfersRequest, core.grpc.proto.CoreApi.AssetTrades> getGetAssetTradesMethod;
    if ((getGetAssetTradesMethod = CoreApiServiceGrpc.getGetAssetTradesMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetAssetTradesMethod = CoreApiServiceGrpc.getGetAssetTradesMethod) == null) {
          CoreApiServiceGrpc.getGetAssetTradesMethod = getGetAssetTradesMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAssetTransfersRequest, core.grpc.proto.CoreApi.AssetTrades>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAssetTrades"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAssetTransfersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.AssetTrades.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAssetTrades"))
                  .build();
          }
        }
     }
     return getGetAssetTradesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAssetTransfersRequest,
      core.grpc.proto.CoreApi.AssetTransfers> getGetAssetTransfersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAssetTransfers",
      requestType = core.grpc.proto.CoreApi.GetAssetTransfersRequest.class,
      responseType = core.grpc.proto.CoreApi.AssetTransfers.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAssetTransfersRequest,
      core.grpc.proto.CoreApi.AssetTransfers> getGetAssetTransfersMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAssetTransfersRequest, core.grpc.proto.CoreApi.AssetTransfers> getGetAssetTransfersMethod;
    if ((getGetAssetTransfersMethod = CoreApiServiceGrpc.getGetAssetTransfersMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetAssetTransfersMethod = CoreApiServiceGrpc.getGetAssetTransfersMethod) == null) {
          CoreApiServiceGrpc.getGetAssetTransfersMethod = getGetAssetTransfersMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAssetTransfersRequest, core.grpc.proto.CoreApi.AssetTransfers>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAssetTransfers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAssetTransfersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.AssetTransfers.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAssetTransfers"))
                  .build();
          }
        }
     }
     return getGetAssetTransfersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest,
      core.grpc.proto.CoreApi.AT> getGetATMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAT",
      requestType = core.grpc.proto.CoreApi.GetByIdRequest.class,
      responseType = core.grpc.proto.CoreApi.AT.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest,
      core.grpc.proto.CoreApi.AT> getGetATMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest, core.grpc.proto.CoreApi.AT> getGetATMethod;
    if ((getGetATMethod = CoreApiServiceGrpc.getGetATMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetATMethod = CoreApiServiceGrpc.getGetATMethod) == null) {
          CoreApiServiceGrpc.getGetATMethod = getGetATMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetByIdRequest, core.grpc.proto.CoreApi.AT>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetAT"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.AT.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetAT"))
                  .build();
          }
        }
     }
     return getGetATMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      core.grpc.proto.CoreApi.ATIds> getGetATIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetATIds",
      requestType = com.google.protobuf.Empty.class,
      responseType = core.grpc.proto.CoreApi.ATIds.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      core.grpc.proto.CoreApi.ATIds> getGetATIdsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, core.grpc.proto.CoreApi.ATIds> getGetATIdsMethod;
    if ((getGetATIdsMethod = CoreApiServiceGrpc.getGetATIdsMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetATIdsMethod = CoreApiServiceGrpc.getGetATIdsMethod) == null) {
          CoreApiServiceGrpc.getGetATIdsMethod = getGetATIdsMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, core.grpc.proto.CoreApi.ATIds>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetATIds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.ATIds.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetATIds"))
                  .build();
          }
        }
     }
     return getGetATIdsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetBlockRequest,
      core.grpc.proto.CoreApi.Block> getGetBlockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBlock",
      requestType = core.grpc.proto.CoreApi.GetBlockRequest.class,
      responseType = core.grpc.proto.CoreApi.Block.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetBlockRequest,
      core.grpc.proto.CoreApi.Block> getGetBlockMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetBlockRequest, core.grpc.proto.CoreApi.Block> getGetBlockMethod;
    if ((getGetBlockMethod = CoreApiServiceGrpc.getGetBlockMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetBlockMethod = CoreApiServiceGrpc.getGetBlockMethod) == null) {
          CoreApiServiceGrpc.getGetBlockMethod = getGetBlockMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetBlockRequest, core.grpc.proto.CoreApi.Block>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetBlock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetBlockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Block.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetBlock"))
                  .build();
          }
        }
     }
     return getGetBlockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetBlocksRequest,
      core.grpc.proto.CoreApi.Blocks> getGetBlocksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBlocks",
      requestType = core.grpc.proto.CoreApi.GetBlocksRequest.class,
      responseType = core.grpc.proto.CoreApi.Blocks.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetBlocksRequest,
      core.grpc.proto.CoreApi.Blocks> getGetBlocksMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetBlocksRequest, core.grpc.proto.CoreApi.Blocks> getGetBlocksMethod;
    if ((getGetBlocksMethod = CoreApiServiceGrpc.getGetBlocksMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetBlocksMethod = CoreApiServiceGrpc.getGetBlocksMethod) == null) {
          CoreApiServiceGrpc.getGetBlocksMethod = getGetBlocksMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetBlocksRequest, core.grpc.proto.CoreApi.Blocks>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetBlocks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetBlocksRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Blocks.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetBlocks"))
                  .build();
          }
        }
     }
     return getGetBlocksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      core.grpc.proto.CoreApi.Constants> getGetConstantsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConstants",
      requestType = com.google.protobuf.Empty.class,
      responseType = core.grpc.proto.CoreApi.Constants.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      core.grpc.proto.CoreApi.Constants> getGetConstantsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, core.grpc.proto.CoreApi.Constants> getGetConstantsMethod;
    if ((getGetConstantsMethod = CoreApiServiceGrpc.getGetConstantsMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetConstantsMethod = CoreApiServiceGrpc.getGetConstantsMethod) == null) {
          CoreApiServiceGrpc.getGetConstantsMethod = getGetConstantsMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, core.grpc.proto.CoreApi.Constants>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetConstants"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Constants.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetConstants"))
                  .build();
          }
        }
     }
     return getGetConstantsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      core.grpc.proto.CoreApi.Counts> getGetCountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCounts",
      requestType = com.google.protobuf.Empty.class,
      responseType = core.grpc.proto.CoreApi.Counts.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      core.grpc.proto.CoreApi.Counts> getGetCountsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, core.grpc.proto.CoreApi.Counts> getGetCountsMethod;
    if ((getGetCountsMethod = CoreApiServiceGrpc.getGetCountsMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetCountsMethod = CoreApiServiceGrpc.getGetCountsMethod) == null) {
          CoreApiServiceGrpc.getGetCountsMethod = getGetCountsMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, core.grpc.proto.CoreApi.Counts>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetCounts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Counts.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetCounts"))
                  .build();
          }
        }
     }
     return getGetCountsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      core.grpc.proto.CoreApi.Time> getGetCurrentTimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCurrentTime",
      requestType = com.google.protobuf.Empty.class,
      responseType = core.grpc.proto.CoreApi.Time.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      core.grpc.proto.CoreApi.Time> getGetCurrentTimeMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, core.grpc.proto.CoreApi.Time> getGetCurrentTimeMethod;
    if ((getGetCurrentTimeMethod = CoreApiServiceGrpc.getGetCurrentTimeMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetCurrentTimeMethod = CoreApiServiceGrpc.getGetCurrentTimeMethod) == null) {
          CoreApiServiceGrpc.getGetCurrentTimeMethod = getGetCurrentTimeMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, core.grpc.proto.CoreApi.Time>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetCurrentTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Time.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetCurrentTime"))
                  .build();
          }
        }
     }
     return getGetCurrentTimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest,
      core.grpc.proto.CoreApi.DgsGood> getGetDgsGoodMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDgsGood",
      requestType = core.grpc.proto.CoreApi.GetByIdRequest.class,
      responseType = core.grpc.proto.CoreApi.DgsGood.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest,
      core.grpc.proto.CoreApi.DgsGood> getGetDgsGoodMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest, core.grpc.proto.CoreApi.DgsGood> getGetDgsGoodMethod;
    if ((getGetDgsGoodMethod = CoreApiServiceGrpc.getGetDgsGoodMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetDgsGoodMethod = CoreApiServiceGrpc.getGetDgsGoodMethod) == null) {
          CoreApiServiceGrpc.getGetDgsGoodMethod = getGetDgsGoodMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetByIdRequest, core.grpc.proto.CoreApi.DgsGood>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetDgsGood"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.DgsGood.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetDgsGood"))
                  .build();
          }
        }
     }
     return getGetDgsGoodMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetDgsGoodsRequest,
      core.grpc.proto.CoreApi.DgsGoods> getGetDgsGoodsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDgsGoods",
      requestType = core.grpc.proto.CoreApi.GetDgsGoodsRequest.class,
      responseType = core.grpc.proto.CoreApi.DgsGoods.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetDgsGoodsRequest,
      core.grpc.proto.CoreApi.DgsGoods> getGetDgsGoodsMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetDgsGoodsRequest, core.grpc.proto.CoreApi.DgsGoods> getGetDgsGoodsMethod;
    if ((getGetDgsGoodsMethod = CoreApiServiceGrpc.getGetDgsGoodsMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetDgsGoodsMethod = CoreApiServiceGrpc.getGetDgsGoodsMethod) == null) {
          CoreApiServiceGrpc.getGetDgsGoodsMethod = getGetDgsGoodsMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetDgsGoodsRequest, core.grpc.proto.CoreApi.DgsGoods>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetDgsGoods"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetDgsGoodsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.DgsGoods.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetDgsGoods"))
                  .build();
          }
        }
     }
     return getGetDgsGoodsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetDgsPendingPurchasesRequest,
      core.grpc.proto.CoreApi.DgsPurchases> getGetDgsPendingPurchasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDgsPendingPurchases",
      requestType = core.grpc.proto.CoreApi.GetDgsPendingPurchasesRequest.class,
      responseType = core.grpc.proto.CoreApi.DgsPurchases.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetDgsPendingPurchasesRequest,
      core.grpc.proto.CoreApi.DgsPurchases> getGetDgsPendingPurchasesMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetDgsPendingPurchasesRequest, core.grpc.proto.CoreApi.DgsPurchases> getGetDgsPendingPurchasesMethod;
    if ((getGetDgsPendingPurchasesMethod = CoreApiServiceGrpc.getGetDgsPendingPurchasesMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetDgsPendingPurchasesMethod = CoreApiServiceGrpc.getGetDgsPendingPurchasesMethod) == null) {
          CoreApiServiceGrpc.getGetDgsPendingPurchasesMethod = getGetDgsPendingPurchasesMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetDgsPendingPurchasesRequest, core.grpc.proto.CoreApi.DgsPurchases>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetDgsPendingPurchases"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetDgsPendingPurchasesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.DgsPurchases.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetDgsPendingPurchases"))
                  .build();
          }
        }
     }
     return getGetDgsPendingPurchasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest,
      core.grpc.proto.CoreApi.DgsPurchase> getGetDgsPurchaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDgsPurchase",
      requestType = core.grpc.proto.CoreApi.GetByIdRequest.class,
      responseType = core.grpc.proto.CoreApi.DgsPurchase.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest,
      core.grpc.proto.CoreApi.DgsPurchase> getGetDgsPurchaseMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest, core.grpc.proto.CoreApi.DgsPurchase> getGetDgsPurchaseMethod;
    if ((getGetDgsPurchaseMethod = CoreApiServiceGrpc.getGetDgsPurchaseMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetDgsPurchaseMethod = CoreApiServiceGrpc.getGetDgsPurchaseMethod) == null) {
          CoreApiServiceGrpc.getGetDgsPurchaseMethod = getGetDgsPurchaseMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetByIdRequest, core.grpc.proto.CoreApi.DgsPurchase>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetDgsPurchase"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.DgsPurchase.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetDgsPurchase"))
                  .build();
          }
        }
     }
     return getGetDgsPurchaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetDgsPurchasesRequest,
      core.grpc.proto.CoreApi.DgsPurchases> getGetDgsPurchasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDgsPurchases",
      requestType = core.grpc.proto.CoreApi.GetDgsPurchasesRequest.class,
      responseType = core.grpc.proto.CoreApi.DgsPurchases.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetDgsPurchasesRequest,
      core.grpc.proto.CoreApi.DgsPurchases> getGetDgsPurchasesMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetDgsPurchasesRequest, core.grpc.proto.CoreApi.DgsPurchases> getGetDgsPurchasesMethod;
    if ((getGetDgsPurchasesMethod = CoreApiServiceGrpc.getGetDgsPurchasesMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetDgsPurchasesMethod = CoreApiServiceGrpc.getGetDgsPurchasesMethod) == null) {
          CoreApiServiceGrpc.getGetDgsPurchasesMethod = getGetDgsPurchasesMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetDgsPurchasesRequest, core.grpc.proto.CoreApi.DgsPurchases>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetDgsPurchases"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetDgsPurchasesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.DgsPurchases.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetDgsPurchases"))
                  .build();
          }
        }
     }
     return getGetDgsPurchasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest,
      core.grpc.proto.CoreApi.EscrowTransaction> getGetEscrowTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEscrowTransaction",
      requestType = core.grpc.proto.CoreApi.GetByIdRequest.class,
      responseType = core.grpc.proto.CoreApi.EscrowTransaction.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest,
      core.grpc.proto.CoreApi.EscrowTransaction> getGetEscrowTransactionMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest, core.grpc.proto.CoreApi.EscrowTransaction> getGetEscrowTransactionMethod;
    if ((getGetEscrowTransactionMethod = CoreApiServiceGrpc.getGetEscrowTransactionMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetEscrowTransactionMethod = CoreApiServiceGrpc.getGetEscrowTransactionMethod) == null) {
          CoreApiServiceGrpc.getGetEscrowTransactionMethod = getGetEscrowTransactionMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetByIdRequest, core.grpc.proto.CoreApi.EscrowTransaction>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetEscrowTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.EscrowTransaction.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetEscrowTransaction"))
                  .build();
          }
        }
     }
     return getGetEscrowTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      core.grpc.proto.CoreApi.MiningInfo> getGetMiningInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMiningInfo",
      requestType = com.google.protobuf.Empty.class,
      responseType = core.grpc.proto.CoreApi.MiningInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      core.grpc.proto.CoreApi.MiningInfo> getGetMiningInfoMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, core.grpc.proto.CoreApi.MiningInfo> getGetMiningInfoMethod;
    if ((getGetMiningInfoMethod = CoreApiServiceGrpc.getGetMiningInfoMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetMiningInfoMethod = CoreApiServiceGrpc.getGetMiningInfoMethod) == null) {
          CoreApiServiceGrpc.getGetMiningInfoMethod = getGetMiningInfoMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, core.grpc.proto.CoreApi.MiningInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetMiningInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.MiningInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetMiningInfo"))
                  .build();
          }
        }
     }
     return getGetMiningInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetOrderRequest,
      core.grpc.proto.CoreApi.Order> getGetOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrder",
      requestType = core.grpc.proto.CoreApi.GetOrderRequest.class,
      responseType = core.grpc.proto.CoreApi.Order.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetOrderRequest,
      core.grpc.proto.CoreApi.Order> getGetOrderMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetOrderRequest, core.grpc.proto.CoreApi.Order> getGetOrderMethod;
    if ((getGetOrderMethod = CoreApiServiceGrpc.getGetOrderMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetOrderMethod = CoreApiServiceGrpc.getGetOrderMethod) == null) {
          CoreApiServiceGrpc.getGetOrderMethod = getGetOrderMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetOrderRequest, core.grpc.proto.CoreApi.Order>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Order.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetOrder"))
                  .build();
          }
        }
     }
     return getGetOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetOrdersRequest,
      core.grpc.proto.CoreApi.Orders> getGetOrdersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrders",
      requestType = core.grpc.proto.CoreApi.GetOrdersRequest.class,
      responseType = core.grpc.proto.CoreApi.Orders.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetOrdersRequest,
      core.grpc.proto.CoreApi.Orders> getGetOrdersMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetOrdersRequest, core.grpc.proto.CoreApi.Orders> getGetOrdersMethod;
    if ((getGetOrdersMethod = CoreApiServiceGrpc.getGetOrdersMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetOrdersMethod = CoreApiServiceGrpc.getGetOrdersMethod) == null) {
          CoreApiServiceGrpc.getGetOrdersMethod = getGetOrdersMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetOrdersRequest, core.grpc.proto.CoreApi.Orders>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetOrders"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetOrdersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Orders.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetOrders"))
                  .build();
          }
        }
     }
     return getGetOrdersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetPeerRequest,
      core.grpc.proto.CoreApi.Peer> getGetPeerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPeer",
      requestType = core.grpc.proto.CoreApi.GetPeerRequest.class,
      responseType = core.grpc.proto.CoreApi.Peer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetPeerRequest,
      core.grpc.proto.CoreApi.Peer> getGetPeerMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetPeerRequest, core.grpc.proto.CoreApi.Peer> getGetPeerMethod;
    if ((getGetPeerMethod = CoreApiServiceGrpc.getGetPeerMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetPeerMethod = CoreApiServiceGrpc.getGetPeerMethod) == null) {
          CoreApiServiceGrpc.getGetPeerMethod = getGetPeerMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetPeerRequest, core.grpc.proto.CoreApi.Peer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetPeer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetPeerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Peer.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetPeer"))
                  .build();
          }
        }
     }
     return getGetPeerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetPeersRequest,
      core.grpc.proto.CoreApi.Peers> getGetPeersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPeers",
      requestType = core.grpc.proto.CoreApi.GetPeersRequest.class,
      responseType = core.grpc.proto.CoreApi.Peers.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetPeersRequest,
      core.grpc.proto.CoreApi.Peers> getGetPeersMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetPeersRequest, core.grpc.proto.CoreApi.Peers> getGetPeersMethod;
    if ((getGetPeersMethod = CoreApiServiceGrpc.getGetPeersMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetPeersMethod = CoreApiServiceGrpc.getGetPeersMethod) == null) {
          CoreApiServiceGrpc.getGetPeersMethod = getGetPeersMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetPeersRequest, core.grpc.proto.CoreApi.Peers>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetPeers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetPeersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Peers.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetPeers"))
                  .build();
          }
        }
     }
     return getGetPeersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      core.grpc.proto.CoreApi.State> getGetStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetState",
      requestType = com.google.protobuf.Empty.class,
      responseType = core.grpc.proto.CoreApi.State.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      core.grpc.proto.CoreApi.State> getGetStateMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, core.grpc.proto.CoreApi.State> getGetStateMethod;
    if ((getGetStateMethod = CoreApiServiceGrpc.getGetStateMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetStateMethod = CoreApiServiceGrpc.getGetStateMethod) == null) {
          CoreApiServiceGrpc.getGetStateMethod = getGetStateMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, core.grpc.proto.CoreApi.State>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.State.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetState"))
                  .build();
          }
        }
     }
     return getGetStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest,
      core.grpc.proto.CoreApi.Subscription> getGetSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubscription",
      requestType = core.grpc.proto.CoreApi.GetByIdRequest.class,
      responseType = core.grpc.proto.CoreApi.Subscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest,
      core.grpc.proto.CoreApi.Subscription> getGetSubscriptionMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetByIdRequest, core.grpc.proto.CoreApi.Subscription> getGetSubscriptionMethod;
    if ((getGetSubscriptionMethod = CoreApiServiceGrpc.getGetSubscriptionMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetSubscriptionMethod = CoreApiServiceGrpc.getGetSubscriptionMethod) == null) {
          CoreApiServiceGrpc.getGetSubscriptionMethod = getGetSubscriptionMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetByIdRequest, core.grpc.proto.CoreApi.Subscription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetSubscription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Subscription.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetSubscription"))
                  .build();
          }
        }
     }
     return getGetSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest,
      core.grpc.proto.CoreApi.Subscriptions> getGetSubscriptionsToAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubscriptionsToAccount",
      requestType = core.grpc.proto.CoreApi.GetAccountRequest.class,
      responseType = core.grpc.proto.CoreApi.Subscriptions.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest,
      core.grpc.proto.CoreApi.Subscriptions> getGetSubscriptionsToAccountMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest, core.grpc.proto.CoreApi.Subscriptions> getGetSubscriptionsToAccountMethod;
    if ((getGetSubscriptionsToAccountMethod = CoreApiServiceGrpc.getGetSubscriptionsToAccountMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetSubscriptionsToAccountMethod = CoreApiServiceGrpc.getGetSubscriptionsToAccountMethod) == null) {
          CoreApiServiceGrpc.getGetSubscriptionsToAccountMethod = getGetSubscriptionsToAccountMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAccountRequest, core.grpc.proto.CoreApi.Subscriptions>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetSubscriptionsToAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Subscriptions.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetSubscriptionsToAccount"))
                  .build();
          }
        }
     }
     return getGetSubscriptionsToAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetTransactionRequest,
      core.grpc.proto.CoreApi.Transaction> getGetTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTransaction",
      requestType = core.grpc.proto.CoreApi.GetTransactionRequest.class,
      responseType = core.grpc.proto.CoreApi.Transaction.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetTransactionRequest,
      core.grpc.proto.CoreApi.Transaction> getGetTransactionMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetTransactionRequest, core.grpc.proto.CoreApi.Transaction> getGetTransactionMethod;
    if ((getGetTransactionMethod = CoreApiServiceGrpc.getGetTransactionMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetTransactionMethod = CoreApiServiceGrpc.getGetTransactionMethod) == null) {
          CoreApiServiceGrpc.getGetTransactionMethod = getGetTransactionMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetTransactionRequest, core.grpc.proto.CoreApi.Transaction>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetTransactionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.Transaction.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetTransaction"))
                  .build();
          }
        }
     }
     return getGetTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.BasicTransaction,
      core.grpc.proto.CoreApi.TransactionBytes> getGetTransactionBytesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTransactionBytes",
      requestType = core.grpc.proto.CoreApi.BasicTransaction.class,
      responseType = core.grpc.proto.CoreApi.TransactionBytes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.BasicTransaction,
      core.grpc.proto.CoreApi.TransactionBytes> getGetTransactionBytesMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.BasicTransaction, core.grpc.proto.CoreApi.TransactionBytes> getGetTransactionBytesMethod;
    if ((getGetTransactionBytesMethod = CoreApiServiceGrpc.getGetTransactionBytesMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetTransactionBytesMethod = CoreApiServiceGrpc.getGetTransactionBytesMethod) == null) {
          CoreApiServiceGrpc.getGetTransactionBytesMethod = getGetTransactionBytesMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.BasicTransaction, core.grpc.proto.CoreApi.TransactionBytes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetTransactionBytes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.BasicTransaction.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.TransactionBytes.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetTransactionBytes"))
                  .build();
          }
        }
     }
     return getGetTransactionBytesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest,
      core.grpc.proto.CoreApi.UnconfirmedTransactions> getGetUnconfirmedTransactionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUnconfirmedTransactions",
      requestType = core.grpc.proto.CoreApi.GetAccountRequest.class,
      responseType = core.grpc.proto.CoreApi.UnconfirmedTransactions.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest,
      core.grpc.proto.CoreApi.UnconfirmedTransactions> getGetUnconfirmedTransactionsMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.GetAccountRequest, core.grpc.proto.CoreApi.UnconfirmedTransactions> getGetUnconfirmedTransactionsMethod;
    if ((getGetUnconfirmedTransactionsMethod = CoreApiServiceGrpc.getGetUnconfirmedTransactionsMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getGetUnconfirmedTransactionsMethod = CoreApiServiceGrpc.getGetUnconfirmedTransactionsMethod) == null) {
          CoreApiServiceGrpc.getGetUnconfirmedTransactionsMethod = getGetUnconfirmedTransactionsMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.GetAccountRequest, core.grpc.proto.CoreApi.UnconfirmedTransactions>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "GetUnconfirmedTransactions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.GetAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.UnconfirmedTransactions.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("GetUnconfirmedTransactions"))
                  .build();
          }
        }
     }
     return getGetUnconfirmedTransactionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.TransactionBytes,
      core.grpc.proto.CoreApi.BasicTransaction> getParseTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ParseTransaction",
      requestType = core.grpc.proto.CoreApi.TransactionBytes.class,
      responseType = core.grpc.proto.CoreApi.BasicTransaction.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.TransactionBytes,
      core.grpc.proto.CoreApi.BasicTransaction> getParseTransactionMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.TransactionBytes, core.grpc.proto.CoreApi.BasicTransaction> getParseTransactionMethod;
    if ((getParseTransactionMethod = CoreApiServiceGrpc.getParseTransactionMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getParseTransactionMethod = CoreApiServiceGrpc.getParseTransactionMethod) == null) {
          CoreApiServiceGrpc.getParseTransactionMethod = getParseTransactionMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.TransactionBytes, core.grpc.proto.CoreApi.BasicTransaction>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "ParseTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.TransactionBytes.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.BasicTransaction.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("ParseTransaction"))
                  .build();
          }
        }
     }
     return getParseTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.SubmitNonceRequest,
      core.grpc.proto.CoreApi.SubmitNonceResponse> getSubmitNonceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubmitNonce",
      requestType = core.grpc.proto.CoreApi.SubmitNonceRequest.class,
      responseType = core.grpc.proto.CoreApi.SubmitNonceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.SubmitNonceRequest,
      core.grpc.proto.CoreApi.SubmitNonceResponse> getSubmitNonceMethod() {
    io.grpc.MethodDescriptor<core.grpc.proto.CoreApi.SubmitNonceRequest, core.grpc.proto.CoreApi.SubmitNonceResponse> getSubmitNonceMethod;
    if ((getSubmitNonceMethod = CoreApiServiceGrpc.getSubmitNonceMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getSubmitNonceMethod = CoreApiServiceGrpc.getSubmitNonceMethod) == null) {
          CoreApiServiceGrpc.getSubmitNonceMethod = getSubmitNonceMethod = 
              io.grpc.MethodDescriptor.<core.grpc.proto.CoreApi.SubmitNonceRequest, core.grpc.proto.CoreApi.SubmitNonceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "SubmitNonce"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.SubmitNonceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.SubmitNonceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("SubmitNonce"))
                  .build();
          }
        }
     }
     return getSubmitNonceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      core.grpc.proto.CoreApi.FeeSuggestion> getSuggestFeeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SuggestFee",
      requestType = com.google.protobuf.Empty.class,
      responseType = core.grpc.proto.CoreApi.FeeSuggestion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      core.grpc.proto.CoreApi.FeeSuggestion> getSuggestFeeMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, core.grpc.proto.CoreApi.FeeSuggestion> getSuggestFeeMethod;
    if ((getSuggestFeeMethod = CoreApiServiceGrpc.getSuggestFeeMethod) == null) {
      synchronized (CoreApiServiceGrpc.class) {
        if ((getSuggestFeeMethod = CoreApiServiceGrpc.getSuggestFeeMethod) == null) {
          CoreApiServiceGrpc.getSuggestFeeMethod = getSuggestFeeMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, core.grpc.proto.CoreApi.FeeSuggestion>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CoreApiService", "SuggestFee"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  core.grpc.proto.CoreApi.FeeSuggestion.getDefaultInstance()))
                  .setSchemaDescriptor(new CoreApiServiceMethodDescriptorSupplier("SuggestFee"))
                  .build();
          }
        }
     }
     return getSuggestFeeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CoreApiServiceStub newStub(io.grpc.Channel channel) {
    return new CoreApiServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CoreApiServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CoreApiServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CoreApiServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CoreApiServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CoreApiServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Broadcast a transaction to the network.
     * </pre>
     */
    public void broadcastTransaction(core.grpc.proto.CoreApi.BasicTransaction request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.TransactionBroadcastResult> responseObserver) {
      asyncUnimplementedUnaryCall(getBroadcastTransactionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Broadcast a transaction to the network. Takes transaction bytes instead of a BasicTransaction
     * </pre>
     */
    public void broadcastTransactionBytes(core.grpc.proto.CoreApi.TransactionBytes request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.TransactionBroadcastResult> responseObserver) {
      asyncUnimplementedUnaryCall(getBroadcastTransactionBytesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Automatically fills in the following fields: Version (based on current transaction version), type and subtype (based on specified attachment), timestamp (current time). Additionally sets attachment to ordinary payment if it was not set
     * </pre>
     */
    public void completeBasicTransaction(core.grpc.proto.CoreApi.BasicTransaction request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.BasicTransaction> responseObserver) {
      asyncUnimplementedUnaryCall(getCompleteBasicTransactionMethod(), responseObserver);
    }

    /**
     */
    public void getAccount(core.grpc.proto.CoreApi.GetAccountRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Account> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAccountMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the ATs that an account is the creator of, by the creator's account ID
     * </pre>
     */
    public void getAccountATs(core.grpc.proto.CoreApi.GetAccountRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.AccountATs> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAccountATsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the blocks that an account has forged, by the forger's ID
     * </pre>
     */
    public void getAccountBlocks(core.grpc.proto.CoreApi.GetAccountBlocksRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Blocks> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAccountBlocksMethod(), responseObserver);
    }

    /**
     */
    public void getAccountCurrentOrders(core.grpc.proto.CoreApi.GetAccountOrdersRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Orders> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAccountCurrentOrdersMethod(), responseObserver);
    }

    /**
     */
    public void getAccountEscrowTransactions(core.grpc.proto.CoreApi.GetAccountRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.EscrowTransactions> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAccountEscrowTransactionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get multiple accounts based on the criteria described in GetAccountsRequest. The criteria is an OR selection - I.E. if you specified a reward recipient and a name it would include accounts that have that recipient and that name, including duplicates. Therefore it is recommended to only select one criteria
     * </pre>
     */
    public void getAccounts(core.grpc.proto.CoreApi.GetAccountsRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Accounts> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAccountsMethod(), responseObserver);
    }

    /**
     */
    public void getAccountSubscriptions(core.grpc.proto.CoreApi.GetAccountRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Subscriptions> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAccountSubscriptionsMethod(), responseObserver);
    }

    /**
     */
    public void getAccountTransactions(core.grpc.proto.CoreApi.GetAccountTransactionsRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Transactions> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAccountTransactionsMethod(), responseObserver);
    }

    /**
     */
    public void getAlias(core.grpc.proto.CoreApi.GetAliasRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Alias> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAliasMethod(), responseObserver);
    }

    /**
     */
    public void getAliases(core.grpc.proto.CoreApi.GetAliasesRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Aliases> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAliasesMethod(), responseObserver);
    }

    /**
     */
    public void getAsset(core.grpc.proto.CoreApi.GetByIdRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Asset> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAssetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get an asset's holders and their balances
     * </pre>
     */
    public void getAssetBalances(core.grpc.proto.CoreApi.GetAssetBalancesRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.AssetBalances> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAssetBalancesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get multiple assets in one go.
     * </pre>
     */
    public void getAssets(core.grpc.proto.CoreApi.GetAssetsRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Assets> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAssetsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get all assets issued by an account
     * </pre>
     */
    public void getAssetsByIssuer(core.grpc.proto.CoreApi.GetAccountRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Assets> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAssetsByIssuerMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get all asset trades made by an account
     * </pre>
     */
    public void getAssetTrades(core.grpc.proto.CoreApi.GetAssetTransfersRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.AssetTrades> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAssetTradesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get all asset transfers made by an account
     * </pre>
     */
    public void getAssetTransfers(core.grpc.proto.CoreApi.GetAssetTransfersRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.AssetTransfers> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAssetTransfersMethod(), responseObserver);
    }

    /**
     */
    public void getAT(core.grpc.proto.CoreApi.GetByIdRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.AT> responseObserver) {
      asyncUnimplementedUnaryCall(getGetATMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get all active AT IDs
     * </pre>
     */
    public void getATIds(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.ATIds> responseObserver) {
      asyncUnimplementedUnaryCall(getGetATIdsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get a block by ID, height or timestamp
     * </pre>
     */
    public void getBlock(core.grpc.proto.CoreApi.GetBlockRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Block> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBlockMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the most recent blocks
     * </pre>
     */
    public void getBlocks(core.grpc.proto.CoreApi.GetBlocksRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Blocks> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBlocksMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the current blockchain constants
     * </pre>
     */
    public void getConstants(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Constants> responseObserver) {
      asyncUnimplementedUnaryCall(getGetConstantsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the counts of different blockchain entities
     * </pre>
     */
    public void getCounts(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Counts> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCountsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the current Pc365 time (number of seconds since Pc365 epoch)
     * </pre>
     */
    public void getCurrentTime(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Time> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentTimeMethod(), responseObserver);
    }

    /**
     */
    public void getDgsGood(core.grpc.proto.CoreApi.GetByIdRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.DgsGood> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDgsGoodMethod(), responseObserver);
    }

    /**
     */
    public void getDgsGoods(core.grpc.proto.CoreApi.GetDgsGoodsRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.DgsGoods> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDgsGoodsMethod(), responseObserver);
    }

    /**
     */
    public void getDgsPendingPurchases(core.grpc.proto.CoreApi.GetDgsPendingPurchasesRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.DgsPurchases> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDgsPendingPurchasesMethod(), responseObserver);
    }

    /**
     */
    public void getDgsPurchase(core.grpc.proto.CoreApi.GetByIdRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.DgsPurchase> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDgsPurchaseMethod(), responseObserver);
    }

    /**
     */
    public void getDgsPurchases(core.grpc.proto.CoreApi.GetDgsPurchasesRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.DgsPurchases> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDgsPurchasesMethod(), responseObserver);
    }

    /**
     */
    public void getEscrowTransaction(core.grpc.proto.CoreApi.GetByIdRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.EscrowTransaction> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEscrowTransactionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the mining info for the next block. This is needed to mine.
     * </pre>
     */
    public void getMiningInfo(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.MiningInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMiningInfoMethod(), responseObserver);
    }

    /**
     */
    public void getOrder(core.grpc.proto.CoreApi.GetOrderRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Order> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOrderMethod(), responseObserver);
    }

    /**
     */
    public void getOrders(core.grpc.proto.CoreApi.GetOrdersRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Orders> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOrdersMethod(), responseObserver);
    }

    /**
     */
    public void getPeer(core.grpc.proto.CoreApi.GetPeerRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Peer> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPeerMethod(), responseObserver);
    }

    /**
     */
    public void getPeers(core.grpc.proto.CoreApi.GetPeersRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Peers> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPeersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the current server state
     * </pre>
     */
    public void getState(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.State> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStateMethod(), responseObserver);
    }

    /**
     */
    public void getSubscription(core.grpc.proto.CoreApi.GetByIdRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Subscription> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSubscriptionMethod(), responseObserver);
    }

    /**
     */
    public void getSubscriptionsToAccount(core.grpc.proto.CoreApi.GetAccountRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Subscriptions> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSubscriptionsToAccountMethod(), responseObserver);
    }

    /**
     */
    public void getTransaction(core.grpc.proto.CoreApi.GetTransactionRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Transaction> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTransactionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Convert a BasicTranscation into its transaction bytes, to be signed. This theoretically can be done offline so will be removed in the future.
     * </pre>
     */
    public void getTransactionBytes(core.grpc.proto.CoreApi.BasicTransaction request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.TransactionBytes> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTransactionBytesMethod(), responseObserver);
    }

    /**
     */
    public void getUnconfirmedTransactions(core.grpc.proto.CoreApi.GetAccountRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.UnconfirmedTransactions> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUnconfirmedTransactionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Convert TransactionBytes into a BasicTransaction. This theoretically can be done offline so will be removed in the future.
     * </pre>
     */
    public void parseTransaction(core.grpc.proto.CoreApi.TransactionBytes request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.BasicTransaction> responseObserver) {
      asyncUnimplementedUnaryCall(getParseTransactionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Submit a nonce to try to forge a block. This requires the passphrase to be sent to the server so should only be performed on local nodes.
     * </pre>
     */
    public void submitNonce(core.grpc.proto.CoreApi.SubmitNonceRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.SubmitNonceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSubmitNonceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Suggest a fee to use for a transaction
     * </pre>
     */
    public void suggestFee(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.FeeSuggestion> responseObserver) {
      asyncUnimplementedUnaryCall(getSuggestFeeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBroadcastTransactionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.BasicTransaction,
                core.grpc.proto.CoreApi.TransactionBroadcastResult>(
                  this, METHODID_BROADCAST_TRANSACTION)))
          .addMethod(
            getBroadcastTransactionBytesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.TransactionBytes,
                core.grpc.proto.CoreApi.TransactionBroadcastResult>(
                  this, METHODID_BROADCAST_TRANSACTION_BYTES)))
          .addMethod(
            getCompleteBasicTransactionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.BasicTransaction,
                core.grpc.proto.CoreApi.BasicTransaction>(
                  this, METHODID_COMPLETE_BASIC_TRANSACTION)))
          .addMethod(
            getGetAccountMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAccountRequest,
                core.grpc.proto.CoreApi.Account>(
                  this, METHODID_GET_ACCOUNT)))
          .addMethod(
            getGetAccountATsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAccountRequest,
                core.grpc.proto.CoreApi.AccountATs>(
                  this, METHODID_GET_ACCOUNT_ATS)))
          .addMethod(
            getGetAccountBlocksMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAccountBlocksRequest,
                core.grpc.proto.CoreApi.Blocks>(
                  this, METHODID_GET_ACCOUNT_BLOCKS)))
          .addMethod(
            getGetAccountCurrentOrdersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAccountOrdersRequest,
                core.grpc.proto.CoreApi.Orders>(
                  this, METHODID_GET_ACCOUNT_CURRENT_ORDERS)))
          .addMethod(
            getGetAccountEscrowTransactionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAccountRequest,
                core.grpc.proto.CoreApi.EscrowTransactions>(
                  this, METHODID_GET_ACCOUNT_ESCROW_TRANSACTIONS)))
          .addMethod(
            getGetAccountsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAccountsRequest,
                core.grpc.proto.CoreApi.Accounts>(
                  this, METHODID_GET_ACCOUNTS)))
          .addMethod(
            getGetAccountSubscriptionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAccountRequest,
                core.grpc.proto.CoreApi.Subscriptions>(
                  this, METHODID_GET_ACCOUNT_SUBSCRIPTIONS)))
          .addMethod(
            getGetAccountTransactionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAccountTransactionsRequest,
                core.grpc.proto.CoreApi.Transactions>(
                  this, METHODID_GET_ACCOUNT_TRANSACTIONS)))
          .addMethod(
            getGetAliasMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAliasRequest,
                core.grpc.proto.CoreApi.Alias>(
                  this, METHODID_GET_ALIAS)))
          .addMethod(
            getGetAliasesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAliasesRequest,
                core.grpc.proto.CoreApi.Aliases>(
                  this, METHODID_GET_ALIASES)))
          .addMethod(
            getGetAssetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetByIdRequest,
                core.grpc.proto.CoreApi.Asset>(
                  this, METHODID_GET_ASSET)))
          .addMethod(
            getGetAssetBalancesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAssetBalancesRequest,
                core.grpc.proto.CoreApi.AssetBalances>(
                  this, METHODID_GET_ASSET_BALANCES)))
          .addMethod(
            getGetAssetsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAssetsRequest,
                core.grpc.proto.CoreApi.Assets>(
                  this, METHODID_GET_ASSETS)))
          .addMethod(
            getGetAssetsByIssuerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAccountRequest,
                core.grpc.proto.CoreApi.Assets>(
                  this, METHODID_GET_ASSETS_BY_ISSUER)))
          .addMethod(
            getGetAssetTradesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAssetTransfersRequest,
                core.grpc.proto.CoreApi.AssetTrades>(
                  this, METHODID_GET_ASSET_TRADES)))
          .addMethod(
            getGetAssetTransfersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAssetTransfersRequest,
                core.grpc.proto.CoreApi.AssetTransfers>(
                  this, METHODID_GET_ASSET_TRANSFERS)))
          .addMethod(
            getGetATMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetByIdRequest,
                core.grpc.proto.CoreApi.AT>(
                  this, METHODID_GET_AT)))
          .addMethod(
            getGetATIdsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                core.grpc.proto.CoreApi.ATIds>(
                  this, METHODID_GET_ATIDS)))
          .addMethod(
            getGetBlockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetBlockRequest,
                core.grpc.proto.CoreApi.Block>(
                  this, METHODID_GET_BLOCK)))
          .addMethod(
            getGetBlocksMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetBlocksRequest,
                core.grpc.proto.CoreApi.Blocks>(
                  this, METHODID_GET_BLOCKS)))
          .addMethod(
            getGetConstantsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                core.grpc.proto.CoreApi.Constants>(
                  this, METHODID_GET_CONSTANTS)))
          .addMethod(
            getGetCountsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                core.grpc.proto.CoreApi.Counts>(
                  this, METHODID_GET_COUNTS)))
          .addMethod(
            getGetCurrentTimeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                core.grpc.proto.CoreApi.Time>(
                  this, METHODID_GET_CURRENT_TIME)))
          .addMethod(
            getGetDgsGoodMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetByIdRequest,
                core.grpc.proto.CoreApi.DgsGood>(
                  this, METHODID_GET_DGS_GOOD)))
          .addMethod(
            getGetDgsGoodsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetDgsGoodsRequest,
                core.grpc.proto.CoreApi.DgsGoods>(
                  this, METHODID_GET_DGS_GOODS)))
          .addMethod(
            getGetDgsPendingPurchasesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetDgsPendingPurchasesRequest,
                core.grpc.proto.CoreApi.DgsPurchases>(
                  this, METHODID_GET_DGS_PENDING_PURCHASES)))
          .addMethod(
            getGetDgsPurchaseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetByIdRequest,
                core.grpc.proto.CoreApi.DgsPurchase>(
                  this, METHODID_GET_DGS_PURCHASE)))
          .addMethod(
            getGetDgsPurchasesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetDgsPurchasesRequest,
                core.grpc.proto.CoreApi.DgsPurchases>(
                  this, METHODID_GET_DGS_PURCHASES)))
          .addMethod(
            getGetEscrowTransactionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetByIdRequest,
                core.grpc.proto.CoreApi.EscrowTransaction>(
                  this, METHODID_GET_ESCROW_TRANSACTION)))
          .addMethod(
            getGetMiningInfoMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                core.grpc.proto.CoreApi.MiningInfo>(
                  this, METHODID_GET_MINING_INFO)))
          .addMethod(
            getGetOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetOrderRequest,
                core.grpc.proto.CoreApi.Order>(
                  this, METHODID_GET_ORDER)))
          .addMethod(
            getGetOrdersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetOrdersRequest,
                core.grpc.proto.CoreApi.Orders>(
                  this, METHODID_GET_ORDERS)))
          .addMethod(
            getGetPeerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetPeerRequest,
                core.grpc.proto.CoreApi.Peer>(
                  this, METHODID_GET_PEER)))
          .addMethod(
            getGetPeersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetPeersRequest,
                core.grpc.proto.CoreApi.Peers>(
                  this, METHODID_GET_PEERS)))
          .addMethod(
            getGetStateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                core.grpc.proto.CoreApi.State>(
                  this, METHODID_GET_STATE)))
          .addMethod(
            getGetSubscriptionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetByIdRequest,
                core.grpc.proto.CoreApi.Subscription>(
                  this, METHODID_GET_SUBSCRIPTION)))
          .addMethod(
            getGetSubscriptionsToAccountMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAccountRequest,
                core.grpc.proto.CoreApi.Subscriptions>(
                  this, METHODID_GET_SUBSCRIPTIONS_TO_ACCOUNT)))
          .addMethod(
            getGetTransactionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetTransactionRequest,
                core.grpc.proto.CoreApi.Transaction>(
                  this, METHODID_GET_TRANSACTION)))
          .addMethod(
            getGetTransactionBytesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.BasicTransaction,
                core.grpc.proto.CoreApi.TransactionBytes>(
                  this, METHODID_GET_TRANSACTION_BYTES)))
          .addMethod(
            getGetUnconfirmedTransactionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.GetAccountRequest,
                core.grpc.proto.CoreApi.UnconfirmedTransactions>(
                  this, METHODID_GET_UNCONFIRMED_TRANSACTIONS)))
          .addMethod(
            getParseTransactionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.TransactionBytes,
                core.grpc.proto.CoreApi.BasicTransaction>(
                  this, METHODID_PARSE_TRANSACTION)))
          .addMethod(
            getSubmitNonceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                core.grpc.proto.CoreApi.SubmitNonceRequest,
                core.grpc.proto.CoreApi.SubmitNonceResponse>(
                  this, METHODID_SUBMIT_NONCE)))
          .addMethod(
            getSuggestFeeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                core.grpc.proto.CoreApi.FeeSuggestion>(
                  this, METHODID_SUGGEST_FEE)))
          .build();
    }
  }

  /**
   */
  public static final class CoreApiServiceStub extends io.grpc.stub.AbstractStub<CoreApiServiceStub> {
    private CoreApiServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CoreApiServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoreApiServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CoreApiServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Broadcast a transaction to the network.
     * </pre>
     */
    public void broadcastTransaction(core.grpc.proto.CoreApi.BasicTransaction request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.TransactionBroadcastResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBroadcastTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Broadcast a transaction to the network. Takes transaction bytes instead of a BasicTransaction
     * </pre>
     */
    public void broadcastTransactionBytes(core.grpc.proto.CoreApi.TransactionBytes request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.TransactionBroadcastResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBroadcastTransactionBytesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Automatically fills in the following fields: Version (based on current transaction version), type and subtype (based on specified attachment), timestamp (current time). Additionally sets attachment to ordinary payment if it was not set
     * </pre>
     */
    public void completeBasicTransaction(core.grpc.proto.CoreApi.BasicTransaction request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.BasicTransaction> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCompleteBasicTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccount(core.grpc.proto.CoreApi.GetAccountRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Account> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the ATs that an account is the creator of, by the creator's account ID
     * </pre>
     */
    public void getAccountATs(core.grpc.proto.CoreApi.GetAccountRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.AccountATs> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAccountATsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the blocks that an account has forged, by the forger's ID
     * </pre>
     */
    public void getAccountBlocks(core.grpc.proto.CoreApi.GetAccountBlocksRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Blocks> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAccountBlocksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccountCurrentOrders(core.grpc.proto.CoreApi.GetAccountOrdersRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Orders> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAccountCurrentOrdersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccountEscrowTransactions(core.grpc.proto.CoreApi.GetAccountRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.EscrowTransactions> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAccountEscrowTransactionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get multiple accounts based on the criteria described in GetAccountsRequest. The criteria is an OR selection - I.E. if you specified a reward recipient and a name it would include accounts that have that recipient and that name, including duplicates. Therefore it is recommended to only select one criteria
     * </pre>
     */
    public void getAccounts(core.grpc.proto.CoreApi.GetAccountsRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Accounts> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAccountsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccountSubscriptions(core.grpc.proto.CoreApi.GetAccountRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Subscriptions> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAccountSubscriptionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccountTransactions(core.grpc.proto.CoreApi.GetAccountTransactionsRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Transactions> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAccountTransactionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAlias(core.grpc.proto.CoreApi.GetAliasRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Alias> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAliasMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAliases(core.grpc.proto.CoreApi.GetAliasesRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Aliases> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAliasesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAsset(core.grpc.proto.CoreApi.GetByIdRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Asset> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAssetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get an asset's holders and their balances
     * </pre>
     */
    public void getAssetBalances(core.grpc.proto.CoreApi.GetAssetBalancesRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.AssetBalances> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAssetBalancesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get multiple assets in one go.
     * </pre>
     */
    public void getAssets(core.grpc.proto.CoreApi.GetAssetsRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Assets> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAssetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get all assets issued by an account
     * </pre>
     */
    public void getAssetsByIssuer(core.grpc.proto.CoreApi.GetAccountRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Assets> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAssetsByIssuerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get all asset trades made by an account
     * </pre>
     */
    public void getAssetTrades(core.grpc.proto.CoreApi.GetAssetTransfersRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.AssetTrades> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAssetTradesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get all asset transfers made by an account
     * </pre>
     */
    public void getAssetTransfers(core.grpc.proto.CoreApi.GetAssetTransfersRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.AssetTransfers> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAssetTransfersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAT(core.grpc.proto.CoreApi.GetByIdRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.AT> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetATMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get all active AT IDs
     * </pre>
     */
    public void getATIds(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.ATIds> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetATIdsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get a block by ID, height or timestamp
     * </pre>
     */
    public void getBlock(core.grpc.proto.CoreApi.GetBlockRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Block> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBlockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the most recent blocks
     * </pre>
     */
    public void getBlocks(core.grpc.proto.CoreApi.GetBlocksRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Blocks> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBlocksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the current blockchain constants
     * </pre>
     */
    public void getConstants(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Constants> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetConstantsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the counts of different blockchain entities
     * </pre>
     */
    public void getCounts(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Counts> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCountsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the current Pc365 time (number of seconds since Pc365 epoch)
     * </pre>
     */
    public void getCurrentTime(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Time> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentTimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDgsGood(core.grpc.proto.CoreApi.GetByIdRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.DgsGood> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDgsGoodMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDgsGoods(core.grpc.proto.CoreApi.GetDgsGoodsRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.DgsGoods> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDgsGoodsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDgsPendingPurchases(core.grpc.proto.CoreApi.GetDgsPendingPurchasesRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.DgsPurchases> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDgsPendingPurchasesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDgsPurchase(core.grpc.proto.CoreApi.GetByIdRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.DgsPurchase> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDgsPurchaseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDgsPurchases(core.grpc.proto.CoreApi.GetDgsPurchasesRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.DgsPurchases> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDgsPurchasesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getEscrowTransaction(core.grpc.proto.CoreApi.GetByIdRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.EscrowTransaction> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetEscrowTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the mining info for the next block. This is needed to mine.
     * </pre>
     */
    public void getMiningInfo(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.MiningInfo> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetMiningInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getOrder(core.grpc.proto.CoreApi.GetOrderRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Order> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getOrders(core.grpc.proto.CoreApi.GetOrdersRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Orders> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetOrdersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPeer(core.grpc.proto.CoreApi.GetPeerRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Peer> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPeerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPeers(core.grpc.proto.CoreApi.GetPeersRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Peers> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPeersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the current server state
     * </pre>
     */
    public void getState(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.State> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSubscription(core.grpc.proto.CoreApi.GetByIdRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Subscription> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSubscriptionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSubscriptionsToAccount(core.grpc.proto.CoreApi.GetAccountRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Subscriptions> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSubscriptionsToAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTransaction(core.grpc.proto.CoreApi.GetTransactionRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Transaction> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Convert a BasicTranscation into its transaction bytes, to be signed. This theoretically can be done offline so will be removed in the future.
     * </pre>
     */
    public void getTransactionBytes(core.grpc.proto.CoreApi.BasicTransaction request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.TransactionBytes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTransactionBytesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUnconfirmedTransactions(core.grpc.proto.CoreApi.GetAccountRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.UnconfirmedTransactions> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUnconfirmedTransactionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Convert TransactionBytes into a BasicTransaction. This theoretically can be done offline so will be removed in the future.
     * </pre>
     */
    public void parseTransaction(core.grpc.proto.CoreApi.TransactionBytes request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.BasicTransaction> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getParseTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Submit a nonce to try to forge a block. This requires the passphrase to be sent to the server so should only be performed on local nodes.
     * </pre>
     */
    public void submitNonce(core.grpc.proto.CoreApi.SubmitNonceRequest request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.SubmitNonceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSubmitNonceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Suggest a fee to use for a transaction
     * </pre>
     */
    public void suggestFee(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.FeeSuggestion> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSuggestFeeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CoreApiServiceBlockingStub extends io.grpc.stub.AbstractStub<CoreApiServiceBlockingStub> {
    private CoreApiServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CoreApiServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoreApiServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CoreApiServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Broadcast a transaction to the network.
     * </pre>
     */
    public core.grpc.proto.CoreApi.TransactionBroadcastResult broadcastTransaction(core.grpc.proto.CoreApi.BasicTransaction request) {
      return blockingUnaryCall(
          getChannel(), getBroadcastTransactionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Broadcast a transaction to the network. Takes transaction bytes instead of a BasicTransaction
     * </pre>
     */
    public core.grpc.proto.CoreApi.TransactionBroadcastResult broadcastTransactionBytes(core.grpc.proto.CoreApi.TransactionBytes request) {
      return blockingUnaryCall(
          getChannel(), getBroadcastTransactionBytesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Automatically fills in the following fields: Version (based on current transaction version), type and subtype (based on specified attachment), timestamp (current time). Additionally sets attachment to ordinary payment if it was not set
     * </pre>
     */
    public core.grpc.proto.CoreApi.BasicTransaction completeBasicTransaction(core.grpc.proto.CoreApi.BasicTransaction request) {
      return blockingUnaryCall(
          getChannel(), getCompleteBasicTransactionMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.Account getAccount(core.grpc.proto.CoreApi.GetAccountRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the ATs that an account is the creator of, by the creator's account ID
     * </pre>
     */
    public core.grpc.proto.CoreApi.AccountATs getAccountATs(core.grpc.proto.CoreApi.GetAccountRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAccountATsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the blocks that an account has forged, by the forger's ID
     * </pre>
     */
    public core.grpc.proto.CoreApi.Blocks getAccountBlocks(core.grpc.proto.CoreApi.GetAccountBlocksRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAccountBlocksMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.Orders getAccountCurrentOrders(core.grpc.proto.CoreApi.GetAccountOrdersRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAccountCurrentOrdersMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.EscrowTransactions getAccountEscrowTransactions(core.grpc.proto.CoreApi.GetAccountRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAccountEscrowTransactionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get multiple accounts based on the criteria described in GetAccountsRequest. The criteria is an OR selection - I.E. if you specified a reward recipient and a name it would include accounts that have that recipient and that name, including duplicates. Therefore it is recommended to only select one criteria
     * </pre>
     */
    public core.grpc.proto.CoreApi.Accounts getAccounts(core.grpc.proto.CoreApi.GetAccountsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAccountsMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.Subscriptions getAccountSubscriptions(core.grpc.proto.CoreApi.GetAccountRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAccountSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.Transactions getAccountTransactions(core.grpc.proto.CoreApi.GetAccountTransactionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAccountTransactionsMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.Alias getAlias(core.grpc.proto.CoreApi.GetAliasRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAliasMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.Aliases getAliases(core.grpc.proto.CoreApi.GetAliasesRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAliasesMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.Asset getAsset(core.grpc.proto.CoreApi.GetByIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAssetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get an asset's holders and their balances
     * </pre>
     */
    public core.grpc.proto.CoreApi.AssetBalances getAssetBalances(core.grpc.proto.CoreApi.GetAssetBalancesRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAssetBalancesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get multiple assets in one go.
     * </pre>
     */
    public core.grpc.proto.CoreApi.Assets getAssets(core.grpc.proto.CoreApi.GetAssetsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAssetsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get all assets issued by an account
     * </pre>
     */
    public core.grpc.proto.CoreApi.Assets getAssetsByIssuer(core.grpc.proto.CoreApi.GetAccountRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAssetsByIssuerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get all asset trades made by an account
     * </pre>
     */
    public core.grpc.proto.CoreApi.AssetTrades getAssetTrades(core.grpc.proto.CoreApi.GetAssetTransfersRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAssetTradesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get all asset transfers made by an account
     * </pre>
     */
    public core.grpc.proto.CoreApi.AssetTransfers getAssetTransfers(core.grpc.proto.CoreApi.GetAssetTransfersRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAssetTransfersMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.AT getAT(core.grpc.proto.CoreApi.GetByIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetATMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get all active AT IDs
     * </pre>
     */
    public core.grpc.proto.CoreApi.ATIds getATIds(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetATIdsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get a block by ID, height or timestamp
     * </pre>
     */
    public core.grpc.proto.CoreApi.Block getBlock(core.grpc.proto.CoreApi.GetBlockRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetBlockMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the most recent blocks
     * </pre>
     */
    public core.grpc.proto.CoreApi.Blocks getBlocks(core.grpc.proto.CoreApi.GetBlocksRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetBlocksMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the current blockchain constants
     * </pre>
     */
    public core.grpc.proto.CoreApi.Constants getConstants(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetConstantsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the counts of different blockchain entities
     * </pre>
     */
    public core.grpc.proto.CoreApi.Counts getCounts(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetCountsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the current Pc365 time (number of seconds since Pc365 epoch)
     * </pre>
     */
    public core.grpc.proto.CoreApi.Time getCurrentTime(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentTimeMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.DgsGood getDgsGood(core.grpc.proto.CoreApi.GetByIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDgsGoodMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.DgsGoods getDgsGoods(core.grpc.proto.CoreApi.GetDgsGoodsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDgsGoodsMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.DgsPurchases getDgsPendingPurchases(core.grpc.proto.CoreApi.GetDgsPendingPurchasesRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDgsPendingPurchasesMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.DgsPurchase getDgsPurchase(core.grpc.proto.CoreApi.GetByIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDgsPurchaseMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.DgsPurchases getDgsPurchases(core.grpc.proto.CoreApi.GetDgsPurchasesRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDgsPurchasesMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.EscrowTransaction getEscrowTransaction(core.grpc.proto.CoreApi.GetByIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetEscrowTransactionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the mining info for the next block. This is needed to mine.
     * </pre>
     */
    public java.util.Iterator<core.grpc.proto.CoreApi.MiningInfo> getMiningInfo(
        com.google.protobuf.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getGetMiningInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.Order getOrder(core.grpc.proto.CoreApi.GetOrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.Orders getOrders(core.grpc.proto.CoreApi.GetOrdersRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetOrdersMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.Peer getPeer(core.grpc.proto.CoreApi.GetPeerRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPeerMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.Peers getPeers(core.grpc.proto.CoreApi.GetPeersRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPeersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the current server state
     * </pre>
     */
    public core.grpc.proto.CoreApi.State getState(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetStateMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.Subscription getSubscription(core.grpc.proto.CoreApi.GetByIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.Subscriptions getSubscriptionsToAccount(core.grpc.proto.CoreApi.GetAccountRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSubscriptionsToAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.Transaction getTransaction(core.grpc.proto.CoreApi.GetTransactionRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTransactionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Convert a BasicTranscation into its transaction bytes, to be signed. This theoretically can be done offline so will be removed in the future.
     * </pre>
     */
    public core.grpc.proto.CoreApi.TransactionBytes getTransactionBytes(core.grpc.proto.CoreApi.BasicTransaction request) {
      return blockingUnaryCall(
          getChannel(), getGetTransactionBytesMethod(), getCallOptions(), request);
    }

    /**
     */
    public core.grpc.proto.CoreApi.UnconfirmedTransactions getUnconfirmedTransactions(core.grpc.proto.CoreApi.GetAccountRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUnconfirmedTransactionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Convert TransactionBytes into a BasicTransaction. This theoretically can be done offline so will be removed in the future.
     * </pre>
     */
    public core.grpc.proto.CoreApi.BasicTransaction parseTransaction(core.grpc.proto.CoreApi.TransactionBytes request) {
      return blockingUnaryCall(
          getChannel(), getParseTransactionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Submit a nonce to try to forge a block. This requires the passphrase to be sent to the server so should only be performed on local nodes.
     * </pre>
     */
    public core.grpc.proto.CoreApi.SubmitNonceResponse submitNonce(core.grpc.proto.CoreApi.SubmitNonceRequest request) {
      return blockingUnaryCall(
          getChannel(), getSubmitNonceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Suggest a fee to use for a transaction
     * </pre>
     */
    public core.grpc.proto.CoreApi.FeeSuggestion suggestFee(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getSuggestFeeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CoreApiServiceFutureStub extends io.grpc.stub.AbstractStub<CoreApiServiceFutureStub> {
    private CoreApiServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CoreApiServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoreApiServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CoreApiServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Broadcast a transaction to the network.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.TransactionBroadcastResult> broadcastTransaction(
        core.grpc.proto.CoreApi.BasicTransaction request) {
      return futureUnaryCall(
          getChannel().newCall(getBroadcastTransactionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Broadcast a transaction to the network. Takes transaction bytes instead of a BasicTransaction
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.TransactionBroadcastResult> broadcastTransactionBytes(
        core.grpc.proto.CoreApi.TransactionBytes request) {
      return futureUnaryCall(
          getChannel().newCall(getBroadcastTransactionBytesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Automatically fills in the following fields: Version (based on current transaction version), type and subtype (based on specified attachment), timestamp (current time). Additionally sets attachment to ordinary payment if it was not set
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.BasicTransaction> completeBasicTransaction(
        core.grpc.proto.CoreApi.BasicTransaction request) {
      return futureUnaryCall(
          getChannel().newCall(getCompleteBasicTransactionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Account> getAccount(
        core.grpc.proto.CoreApi.GetAccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the ATs that an account is the creator of, by the creator's account ID
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.AccountATs> getAccountATs(
        core.grpc.proto.CoreApi.GetAccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAccountATsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the blocks that an account has forged, by the forger's ID
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Blocks> getAccountBlocks(
        core.grpc.proto.CoreApi.GetAccountBlocksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAccountBlocksMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Orders> getAccountCurrentOrders(
        core.grpc.proto.CoreApi.GetAccountOrdersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAccountCurrentOrdersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.EscrowTransactions> getAccountEscrowTransactions(
        core.grpc.proto.CoreApi.GetAccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAccountEscrowTransactionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get multiple accounts based on the criteria described in GetAccountsRequest. The criteria is an OR selection - I.E. if you specified a reward recipient and a name it would include accounts that have that recipient and that name, including duplicates. Therefore it is recommended to only select one criteria
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Accounts> getAccounts(
        core.grpc.proto.CoreApi.GetAccountsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAccountsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Subscriptions> getAccountSubscriptions(
        core.grpc.proto.CoreApi.GetAccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAccountSubscriptionsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Transactions> getAccountTransactions(
        core.grpc.proto.CoreApi.GetAccountTransactionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAccountTransactionsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Alias> getAlias(
        core.grpc.proto.CoreApi.GetAliasRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAliasMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Aliases> getAliases(
        core.grpc.proto.CoreApi.GetAliasesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAliasesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Asset> getAsset(
        core.grpc.proto.CoreApi.GetByIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAssetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get an asset's holders and their balances
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.AssetBalances> getAssetBalances(
        core.grpc.proto.CoreApi.GetAssetBalancesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAssetBalancesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get multiple assets in one go.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Assets> getAssets(
        core.grpc.proto.CoreApi.GetAssetsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAssetsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get all assets issued by an account
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Assets> getAssetsByIssuer(
        core.grpc.proto.CoreApi.GetAccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAssetsByIssuerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get all asset trades made by an account
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.AssetTrades> getAssetTrades(
        core.grpc.proto.CoreApi.GetAssetTransfersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAssetTradesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get all asset transfers made by an account
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.AssetTransfers> getAssetTransfers(
        core.grpc.proto.CoreApi.GetAssetTransfersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAssetTransfersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.AT> getAT(
        core.grpc.proto.CoreApi.GetByIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetATMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get all active AT IDs
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.ATIds> getATIds(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetATIdsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get a block by ID, height or timestamp
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Block> getBlock(
        core.grpc.proto.CoreApi.GetBlockRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBlockMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the most recent blocks
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Blocks> getBlocks(
        core.grpc.proto.CoreApi.GetBlocksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBlocksMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the current blockchain constants
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Constants> getConstants(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetConstantsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the counts of different blockchain entities
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Counts> getCounts(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCountsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the current Pc365 time (number of seconds since Pc365 epoch)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Time> getCurrentTime(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCurrentTimeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.DgsGood> getDgsGood(
        core.grpc.proto.CoreApi.GetByIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDgsGoodMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.DgsGoods> getDgsGoods(
        core.grpc.proto.CoreApi.GetDgsGoodsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDgsGoodsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.DgsPurchases> getDgsPendingPurchases(
        core.grpc.proto.CoreApi.GetDgsPendingPurchasesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDgsPendingPurchasesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.DgsPurchase> getDgsPurchase(
        core.grpc.proto.CoreApi.GetByIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDgsPurchaseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.DgsPurchases> getDgsPurchases(
        core.grpc.proto.CoreApi.GetDgsPurchasesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDgsPurchasesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.EscrowTransaction> getEscrowTransaction(
        core.grpc.proto.CoreApi.GetByIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetEscrowTransactionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Order> getOrder(
        core.grpc.proto.CoreApi.GetOrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Orders> getOrders(
        core.grpc.proto.CoreApi.GetOrdersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetOrdersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Peer> getPeer(
        core.grpc.proto.CoreApi.GetPeerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPeerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Peers> getPeers(
        core.grpc.proto.CoreApi.GetPeersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPeersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the current server state
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.State> getState(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Subscription> getSubscription(
        core.grpc.proto.CoreApi.GetByIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Subscriptions> getSubscriptionsToAccount(
        core.grpc.proto.CoreApi.GetAccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSubscriptionsToAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.Transaction> getTransaction(
        core.grpc.proto.CoreApi.GetTransactionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTransactionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Convert a BasicTranscation into its transaction bytes, to be signed. This theoretically can be done offline so will be removed in the future.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.TransactionBytes> getTransactionBytes(
        core.grpc.proto.CoreApi.BasicTransaction request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTransactionBytesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.UnconfirmedTransactions> getUnconfirmedTransactions(
        core.grpc.proto.CoreApi.GetAccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUnconfirmedTransactionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Convert TransactionBytes into a BasicTransaction. This theoretically can be done offline so will be removed in the future.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.BasicTransaction> parseTransaction(
        core.grpc.proto.CoreApi.TransactionBytes request) {
      return futureUnaryCall(
          getChannel().newCall(getParseTransactionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Submit a nonce to try to forge a block. This requires the passphrase to be sent to the server so should only be performed on local nodes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.SubmitNonceResponse> submitNonce(
        core.grpc.proto.CoreApi.SubmitNonceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSubmitNonceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Suggest a fee to use for a transaction
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<core.grpc.proto.CoreApi.FeeSuggestion> suggestFee(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getSuggestFeeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BROADCAST_TRANSACTION = 0;
  private static final int METHODID_BROADCAST_TRANSACTION_BYTES = 1;
  private static final int METHODID_COMPLETE_BASIC_TRANSACTION = 2;
  private static final int METHODID_GET_ACCOUNT = 3;
  private static final int METHODID_GET_ACCOUNT_ATS = 4;
  private static final int METHODID_GET_ACCOUNT_BLOCKS = 5;
  private static final int METHODID_GET_ACCOUNT_CURRENT_ORDERS = 6;
  private static final int METHODID_GET_ACCOUNT_ESCROW_TRANSACTIONS = 7;
  private static final int METHODID_GET_ACCOUNTS = 8;
  private static final int METHODID_GET_ACCOUNT_SUBSCRIPTIONS = 9;
  private static final int METHODID_GET_ACCOUNT_TRANSACTIONS = 10;
  private static final int METHODID_GET_ALIAS = 11;
  private static final int METHODID_GET_ALIASES = 12;
  private static final int METHODID_GET_ASSET = 13;
  private static final int METHODID_GET_ASSET_BALANCES = 14;
  private static final int METHODID_GET_ASSETS = 15;
  private static final int METHODID_GET_ASSETS_BY_ISSUER = 16;
  private static final int METHODID_GET_ASSET_TRADES = 17;
  private static final int METHODID_GET_ASSET_TRANSFERS = 18;
  private static final int METHODID_GET_AT = 19;
  private static final int METHODID_GET_ATIDS = 20;
  private static final int METHODID_GET_BLOCK = 21;
  private static final int METHODID_GET_BLOCKS = 22;
  private static final int METHODID_GET_CONSTANTS = 23;
  private static final int METHODID_GET_COUNTS = 24;
  private static final int METHODID_GET_CURRENT_TIME = 25;
  private static final int METHODID_GET_DGS_GOOD = 26;
  private static final int METHODID_GET_DGS_GOODS = 27;
  private static final int METHODID_GET_DGS_PENDING_PURCHASES = 28;
  private static final int METHODID_GET_DGS_PURCHASE = 29;
  private static final int METHODID_GET_DGS_PURCHASES = 30;
  private static final int METHODID_GET_ESCROW_TRANSACTION = 31;
  private static final int METHODID_GET_MINING_INFO = 32;
  private static final int METHODID_GET_ORDER = 33;
  private static final int METHODID_GET_ORDERS = 34;
  private static final int METHODID_GET_PEER = 35;
  private static final int METHODID_GET_PEERS = 36;
  private static final int METHODID_GET_STATE = 37;
  private static final int METHODID_GET_SUBSCRIPTION = 38;
  private static final int METHODID_GET_SUBSCRIPTIONS_TO_ACCOUNT = 39;
  private static final int METHODID_GET_TRANSACTION = 40;
  private static final int METHODID_GET_TRANSACTION_BYTES = 41;
  private static final int METHODID_GET_UNCONFIRMED_TRANSACTIONS = 42;
  private static final int METHODID_PARSE_TRANSACTION = 43;
  private static final int METHODID_SUBMIT_NONCE = 44;
  private static final int METHODID_SUGGEST_FEE = 45;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CoreApiServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CoreApiServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BROADCAST_TRANSACTION:
          serviceImpl.broadcastTransaction((core.grpc.proto.CoreApi.BasicTransaction) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.TransactionBroadcastResult>) responseObserver);
          break;
        case METHODID_BROADCAST_TRANSACTION_BYTES:
          serviceImpl.broadcastTransactionBytes((core.grpc.proto.CoreApi.TransactionBytes) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.TransactionBroadcastResult>) responseObserver);
          break;
        case METHODID_COMPLETE_BASIC_TRANSACTION:
          serviceImpl.completeBasicTransaction((core.grpc.proto.CoreApi.BasicTransaction) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.BasicTransaction>) responseObserver);
          break;
        case METHODID_GET_ACCOUNT:
          serviceImpl.getAccount((core.grpc.proto.CoreApi.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Account>) responseObserver);
          break;
        case METHODID_GET_ACCOUNT_ATS:
          serviceImpl.getAccountATs((core.grpc.proto.CoreApi.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.AccountATs>) responseObserver);
          break;
        case METHODID_GET_ACCOUNT_BLOCKS:
          serviceImpl.getAccountBlocks((core.grpc.proto.CoreApi.GetAccountBlocksRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Blocks>) responseObserver);
          break;
        case METHODID_GET_ACCOUNT_CURRENT_ORDERS:
          serviceImpl.getAccountCurrentOrders((core.grpc.proto.CoreApi.GetAccountOrdersRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Orders>) responseObserver);
          break;
        case METHODID_GET_ACCOUNT_ESCROW_TRANSACTIONS:
          serviceImpl.getAccountEscrowTransactions((core.grpc.proto.CoreApi.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.EscrowTransactions>) responseObserver);
          break;
        case METHODID_GET_ACCOUNTS:
          serviceImpl.getAccounts((core.grpc.proto.CoreApi.GetAccountsRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Accounts>) responseObserver);
          break;
        case METHODID_GET_ACCOUNT_SUBSCRIPTIONS:
          serviceImpl.getAccountSubscriptions((core.grpc.proto.CoreApi.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Subscriptions>) responseObserver);
          break;
        case METHODID_GET_ACCOUNT_TRANSACTIONS:
          serviceImpl.getAccountTransactions((core.grpc.proto.CoreApi.GetAccountTransactionsRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Transactions>) responseObserver);
          break;
        case METHODID_GET_ALIAS:
          serviceImpl.getAlias((core.grpc.proto.CoreApi.GetAliasRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Alias>) responseObserver);
          break;
        case METHODID_GET_ALIASES:
          serviceImpl.getAliases((core.grpc.proto.CoreApi.GetAliasesRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Aliases>) responseObserver);
          break;
        case METHODID_GET_ASSET:
          serviceImpl.getAsset((core.grpc.proto.CoreApi.GetByIdRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Asset>) responseObserver);
          break;
        case METHODID_GET_ASSET_BALANCES:
          serviceImpl.getAssetBalances((core.grpc.proto.CoreApi.GetAssetBalancesRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.AssetBalances>) responseObserver);
          break;
        case METHODID_GET_ASSETS:
          serviceImpl.getAssets((core.grpc.proto.CoreApi.GetAssetsRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Assets>) responseObserver);
          break;
        case METHODID_GET_ASSETS_BY_ISSUER:
          serviceImpl.getAssetsByIssuer((core.grpc.proto.CoreApi.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Assets>) responseObserver);
          break;
        case METHODID_GET_ASSET_TRADES:
          serviceImpl.getAssetTrades((core.grpc.proto.CoreApi.GetAssetTransfersRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.AssetTrades>) responseObserver);
          break;
        case METHODID_GET_ASSET_TRANSFERS:
          serviceImpl.getAssetTransfers((core.grpc.proto.CoreApi.GetAssetTransfersRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.AssetTransfers>) responseObserver);
          break;
        case METHODID_GET_AT:
          serviceImpl.getAT((core.grpc.proto.CoreApi.GetByIdRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.AT>) responseObserver);
          break;
        case METHODID_GET_ATIDS:
          serviceImpl.getATIds((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.ATIds>) responseObserver);
          break;
        case METHODID_GET_BLOCK:
          serviceImpl.getBlock((core.grpc.proto.CoreApi.GetBlockRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Block>) responseObserver);
          break;
        case METHODID_GET_BLOCKS:
          serviceImpl.getBlocks((core.grpc.proto.CoreApi.GetBlocksRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Blocks>) responseObserver);
          break;
        case METHODID_GET_CONSTANTS:
          serviceImpl.getConstants((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Constants>) responseObserver);
          break;
        case METHODID_GET_COUNTS:
          serviceImpl.getCounts((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Counts>) responseObserver);
          break;
        case METHODID_GET_CURRENT_TIME:
          serviceImpl.getCurrentTime((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Time>) responseObserver);
          break;
        case METHODID_GET_DGS_GOOD:
          serviceImpl.getDgsGood((core.grpc.proto.CoreApi.GetByIdRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.DgsGood>) responseObserver);
          break;
        case METHODID_GET_DGS_GOODS:
          serviceImpl.getDgsGoods((core.grpc.proto.CoreApi.GetDgsGoodsRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.DgsGoods>) responseObserver);
          break;
        case METHODID_GET_DGS_PENDING_PURCHASES:
          serviceImpl.getDgsPendingPurchases((core.grpc.proto.CoreApi.GetDgsPendingPurchasesRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.DgsPurchases>) responseObserver);
          break;
        case METHODID_GET_DGS_PURCHASE:
          serviceImpl.getDgsPurchase((core.grpc.proto.CoreApi.GetByIdRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.DgsPurchase>) responseObserver);
          break;
        case METHODID_GET_DGS_PURCHASES:
          serviceImpl.getDgsPurchases((core.grpc.proto.CoreApi.GetDgsPurchasesRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.DgsPurchases>) responseObserver);
          break;
        case METHODID_GET_ESCROW_TRANSACTION:
          serviceImpl.getEscrowTransaction((core.grpc.proto.CoreApi.GetByIdRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.EscrowTransaction>) responseObserver);
          break;
        case METHODID_GET_MINING_INFO:
          serviceImpl.getMiningInfo((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.MiningInfo>) responseObserver);
          break;
        case METHODID_GET_ORDER:
          serviceImpl.getOrder((core.grpc.proto.CoreApi.GetOrderRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Order>) responseObserver);
          break;
        case METHODID_GET_ORDERS:
          serviceImpl.getOrders((core.grpc.proto.CoreApi.GetOrdersRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Orders>) responseObserver);
          break;
        case METHODID_GET_PEER:
          serviceImpl.getPeer((core.grpc.proto.CoreApi.GetPeerRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Peer>) responseObserver);
          break;
        case METHODID_GET_PEERS:
          serviceImpl.getPeers((core.grpc.proto.CoreApi.GetPeersRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Peers>) responseObserver);
          break;
        case METHODID_GET_STATE:
          serviceImpl.getState((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.State>) responseObserver);
          break;
        case METHODID_GET_SUBSCRIPTION:
          serviceImpl.getSubscription((core.grpc.proto.CoreApi.GetByIdRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Subscription>) responseObserver);
          break;
        case METHODID_GET_SUBSCRIPTIONS_TO_ACCOUNT:
          serviceImpl.getSubscriptionsToAccount((core.grpc.proto.CoreApi.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Subscriptions>) responseObserver);
          break;
        case METHODID_GET_TRANSACTION:
          serviceImpl.getTransaction((core.grpc.proto.CoreApi.GetTransactionRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.Transaction>) responseObserver);
          break;
        case METHODID_GET_TRANSACTION_BYTES:
          serviceImpl.getTransactionBytes((core.grpc.proto.CoreApi.BasicTransaction) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.TransactionBytes>) responseObserver);
          break;
        case METHODID_GET_UNCONFIRMED_TRANSACTIONS:
          serviceImpl.getUnconfirmedTransactions((core.grpc.proto.CoreApi.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.UnconfirmedTransactions>) responseObserver);
          break;
        case METHODID_PARSE_TRANSACTION:
          serviceImpl.parseTransaction((core.grpc.proto.CoreApi.TransactionBytes) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.BasicTransaction>) responseObserver);
          break;
        case METHODID_SUBMIT_NONCE:
          serviceImpl.submitNonce((core.grpc.proto.CoreApi.SubmitNonceRequest) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.SubmitNonceResponse>) responseObserver);
          break;
        case METHODID_SUGGEST_FEE:
          serviceImpl.suggestFee((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<core.grpc.proto.CoreApi.FeeSuggestion>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CoreApiServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CoreApiServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return core.grpc.proto.CoreApi.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CoreApiService");
    }
  }

  private static final class CoreApiServiceFileDescriptorSupplier
      extends CoreApiServiceBaseDescriptorSupplier {
    CoreApiServiceFileDescriptorSupplier() {}
  }

  private static final class CoreApiServiceMethodDescriptorSupplier
      extends CoreApiServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CoreApiServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CoreApiServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CoreApiServiceFileDescriptorSupplier())
              .addMethod(getBroadcastTransactionMethod())
              .addMethod(getBroadcastTransactionBytesMethod())
              .addMethod(getCompleteBasicTransactionMethod())
              .addMethod(getGetAccountMethod())
              .addMethod(getGetAccountATsMethod())
              .addMethod(getGetAccountBlocksMethod())
              .addMethod(getGetAccountCurrentOrdersMethod())
              .addMethod(getGetAccountEscrowTransactionsMethod())
              .addMethod(getGetAccountsMethod())
              .addMethod(getGetAccountSubscriptionsMethod())
              .addMethod(getGetAccountTransactionsMethod())
              .addMethod(getGetAliasMethod())
              .addMethod(getGetAliasesMethod())
              .addMethod(getGetAssetMethod())
              .addMethod(getGetAssetBalancesMethod())
              .addMethod(getGetAssetsMethod())
              .addMethod(getGetAssetsByIssuerMethod())
              .addMethod(getGetAssetTradesMethod())
              .addMethod(getGetAssetTransfersMethod())
              .addMethod(getGetATMethod())
              .addMethod(getGetATIdsMethod())
              .addMethod(getGetBlockMethod())
              .addMethod(getGetBlocksMethod())
              .addMethod(getGetConstantsMethod())
              .addMethod(getGetCountsMethod())
              .addMethod(getGetCurrentTimeMethod())
              .addMethod(getGetDgsGoodMethod())
              .addMethod(getGetDgsGoodsMethod())
              .addMethod(getGetDgsPendingPurchasesMethod())
              .addMethod(getGetDgsPurchaseMethod())
              .addMethod(getGetDgsPurchasesMethod())
              .addMethod(getGetEscrowTransactionMethod())
              .addMethod(getGetMiningInfoMethod())
              .addMethod(getGetOrderMethod())
              .addMethod(getGetOrdersMethod())
              .addMethod(getGetPeerMethod())
              .addMethod(getGetPeersMethod())
              .addMethod(getGetStateMethod())
              .addMethod(getGetSubscriptionMethod())
              .addMethod(getGetSubscriptionsToAccountMethod())
              .addMethod(getGetTransactionMethod())
              .addMethod(getGetTransactionBytesMethod())
              .addMethod(getGetUnconfirmedTransactionsMethod())
              .addMethod(getParseTransactionMethod())
              .addMethod(getSubmitNonceMethod())
              .addMethod(getSuggestFeeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
