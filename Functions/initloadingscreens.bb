Function initloadingscreens%(arg0$)
    Local local0$
    Local local1%
    Local local2.loadingscreens
    Local local3%
    local3 = openfile(arg0)
    While (eof(local3) = $00)
        local0 = trim(readline(local3))
        If (left(local0, $01) = "[") Then
            local0 = mid(local0, $02, (len(local0) - $02))
            local2 = (New loadingscreens)
            loadingscreenamount = (loadingscreenamount + $01)
            local2\Field2 = loadingscreenamount
            local2\Field3 = local0
            local2\Field0 = scpmodding_processfilepath(getinistring(arg0, local0, "image path", ""))
            For local1 = $00 To $04 Step $01
                local2\Field7[local1] = getinistring(arg0, local0, ("text" + (Str (local1 + $01))), "")
                If (local2\Field7[local1] <> "") Then
                    local2\Field8 = (local2\Field8 + $01)
                EndIf
            Next
            local2\Field6 = getiniint(arg0, local0, "disablebackground", $00)
            Select lower(getinistring(arg0, local0, "align x", ""))
                Case "left"
                    local2\Field4 = $FFFFFFFF
                Case "middle","center"
                    local2\Field4 = $00
                Case "right"
                    local2\Field4 = $01
            End Select
            Select lower(getinistring(arg0, local0, "align y", ""))
                Case "top","up"
                    local2\Field5 = $FFFFFFFF
                Case "middle","center"
                    local2\Field5 = $00
                Case "bottom","down"
                    local2\Field5 = $01
            End Select
        EndIf
    Wend
    closefile(local3)
    Return $00
End Function
