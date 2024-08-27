Function getmeshextents%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5#
    Local local6#
    Local local7#
    Local local8%
    Local local9#
    Local local10#
    Local local11#
    Local local12#
    Local local13#
    Local local14#
    local9 = (Float local8)
    local10 = (Float local8)
    local11 = (Float local8)
    local12 = (Float (- local8))
    local13 = (Float (- local8))
    local14 = (Float (- local8))
    local2 = countsurfaces(arg0)
    For local0 = $01 To local2 Step $01
        local1 = getsurface(arg0, local0)
        local4 = countvertices(local1)
        For local3 = $00 To (local4 - $01) Step $01
            local5 = vertexx(local1, local3)
            local6 = vertexy(local1, local3)
            local7 = vertexz(local1, local3)
            If (local9 > local5) Then
                local9 = local5
            EndIf
            If (local12 < local5) Then
                local12 = local5
            EndIf
            If (local10 > local6) Then
                local10 = local6
            EndIf
            If (local13 < local6) Then
                local13 = local6
            EndIf
            If (local11 > local7) Then
                local11 = local7
            EndIf
            If (local14 < local7) Then
                local14 = local7
            EndIf
        Next
    Next
    mesh_minx = local9
    mesh_miny = local10
    mesh_minz = local11
    mesh_maxx = local12
    mesh_maxy = local13
    mesh_maxz = local14
    mesh_magx = (local12 - local9)
    mesh_magy = (local13 - local10)
    mesh_magz = (local14 - local11)
    Return $00
End Function
