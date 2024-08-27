Function drawmapcreatortooltip%(arg0%, arg1%, arg2%, arg3%, arg4$)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4%
    Local local5.fonts
    Local local6$[5]
    Local local7%
    Local local8$
    Local local9$
    Local local10%
    Local local11%
    Local local12%
    local0 = ((6.0 * menuscale) + (Float arg0))
    local1 = ((6.0 * menuscale) + (Float arg1))
    local2 = ((Float arg2) - (12.0 * menuscale))
    local3 = ((Float arg3) - (12.0 * menuscale))
    local4 = $00
    local5 = (First fonts)
    aasetfont(local5\Field0[$00])
    color($FF, $FF, $FF)
    If (right(arg4, $06) = "cbmap2") Then
        local6[$00] = left(arg4, (len(arg4) - $07))
        local7 = openfile(("Map Creator\Maps\" + arg4))
        local8 = readline(local7)
        local9 = readline(local7)
        readbyte(local7)
        readbyte(local7)
        local10 = readint(local7)
        If (readint(local7) > $00) Then
            local11 = $01
        Else
            local11 = $00
        EndIf
        If (readint(local7) > $00) Then
            local12 = $01
        Else
            local12 = $00
        EndIf
        closefile(local7)
    Else
        local6[$00] = left(arg4, (len(arg4) - $06))
        local8 = scplang_getphrase("tooltips.mapauthorunknown")
        local9 = scplang_getphrase("tooltips.mapdescnone")
        local10 = $00
        local11 = $00
        local12 = $00
    EndIf
    local6[$01] = ((scplang_getphrase("tooltips.mapmadeby") + " ") + local8)
    local6[$02] = ((scplang_getphrase("tooltips.mapdesc") + " ") + local9)
    If (local10 > $00) Then
        local6[$03] = ((scplang_getphrase("tooltips.maproomamm") + " ") + (Str local10))
    Else
        local6[$03] = scplang_getphrase("tooltips.maproomammunknown")
    EndIf
    If (local11 <> 0) Then
        local6[$04] = ((scplang_getphrase("tooltips.mapforest") + " ") + scplang_getphrase("menu.yes"))
    Else
        local6[$04] = ((scplang_getphrase("tooltips.mapforest") + " ") + scplang_getphrase("menu.no"))
    EndIf
    If (local12 <> 0) Then
        local6[$05] = ((scplang_getphrase("tooltips.mapmaintenance") + " ") + scplang_getphrase("menu.yes"))
    Else
        local6[$05] = ((scplang_getphrase("tooltips.mapmaintenance") + " ") + scplang_getphrase("menu.no"))
    EndIf
    local4 = getlineamount(local6[$02], (Int local2), (Int local3), 1.0)
    drawframe(arg0, arg1, arg2, (Int ((Float ((aastringheight(local6[$00]) * $06) + (aastringheight(local6[$02]) * local4))) + (5.0 * menuscale))), $00, $00)
    color($FF, $FF, $FF)
    aatext((Int local0), (Int local1), local6[$00], $00, $00, 1.0)
    aatext((Int local0), (Int (local1 + (Float aastringheight(local6[$00])))), local6[$01], $00, $00, 1.0)
    rowtext(local6[$02], (Int local0), (Int (local1 + (Float (aastringheight(local6[$00]) Shl $01)))), (Int local2), (Int local3), $00, 1.0)
    aatext((Int local0), (Int (((Float ((aastringheight(local6[$00]) Shl $01) + (aastringheight(local6[$02]) * local4))) + (5.0 * menuscale)) + local1)), local6[$03], $00, $00, 1.0)
    aatext((Int local0), (Int (((Float ((aastringheight(local6[$00]) * $03) + (aastringheight(local6[$02]) * local4))) + (5.0 * menuscale)) + local1)), local6[$04], $00, $00, 1.0)
    aatext((Int local0), (Int (((Float ((aastringheight(local6[$00]) Shl $02) + (aastringheight(local6[$02]) * local4))) + (5.0 * menuscale)) + local1)), local6[$05], $00, $00, 1.0)
    Return $00
End Function
