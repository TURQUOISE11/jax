package cn.lhemi.jax.util;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

/**
 * @description:
 * @author: TURQUOISE
 * @create: 2019-08-08 11:59
 */
public class RemoteAddressUtil {

    public static String address(ChannelHandlerContext ctx) {
        return address(ctx.channel());
    }

    public static String address(Channel channel) {
        return channel.remoteAddress().toString().replace("/", "");
    }
}
